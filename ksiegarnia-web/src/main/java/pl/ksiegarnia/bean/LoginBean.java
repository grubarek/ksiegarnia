package pl.ksiegarnia.bean;

import pl.ksiegarnia.dao.UserDao;
import pl.ksiegarnia.jpa.User;
import pl.ksiegarnia.utils.Navigation;
import pl.ksiegarnia.utils.UtilsBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by pgrubarek on 11.08.15.
 */
@ManagedBean
@RequestScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 5582641298743595112L;

    Logger logger = Logger.getLogger(LoginBean.class.toString());

    @ManagedProperty(value="#{sessionBean}")
    private SessionBean sessionBean;

    @ManagedProperty(value="#{utilsBean}")
    private UtilsBean utils;

    @EJB
    UserDao accountDao;



    private String login;
    private String password;

    public LoginBean() {
    }

    @PostConstruct
    public void init() {
        logger.info("LoginBean.init - invoke");
        if(sessionBean.isLogged()) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("pages/user/list.xhtml");
            } catch (Exception e) {
                logger.log(Level.SEVERE, "LoginBean.init - IOException", e);
            }
        }
    }

    /**
     * Loguje użytkownika w CMSie. Pobiera listę jego ról.
     *
     * W przypadku błędu pokazuje stosowny  komunikat i zostawia użytkownika na obecnej stronie.
     *
     * @return
     */
    public String login() {
        logger.info(String.format("LoginBean.login - invoke, login=%s password: *************", login));

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        try {
            User user = accountDao.getUserByLogin(login);

            if (user == null) {
                sessionBean.showError("Błędny login lub hasło.");
                return null;
            } else {
                if (user.getStatus() == User.STATUS_BLOCKED) {
                    sessionBean.showError("Konto zostało zablokowane.");
                    return null;
                } else if (user.getStatus() != User.STATUS_ACTIVE) {
                    sessionBean.showError("Błędny login lub hasło.");
                    return null;
                }
            }
            if (accountDao.authorize(login, password) == null) {
                if (user.getStatus() == User.STATUS_BLOCKED) {
                    sessionBean.showError("Konto zostało zablokowane.");
                } else {
                    sessionBean.showError("Błędny login lub hasło.");
                }
                return null;
            }
            request.login(login, user.getPasswordSalt() + password);
            logger.info("login, user validated.");
            // Zapisanie sesji, etc.
            writeSessionData(request, user);

        } catch (Exception e) {
            sessionBean.showError("Błędny login lub hasło.");
            logger.log(Level.SEVERE, "LoginBean.login - DaoException (user not found)", e);
            return null;
        }

        return Navigation.HOMEPAGE;
    }


    private void writeSessionData(HttpServletRequest request, User user) {
        sessionBean.login(login);
        sessionBean.put(SessionBean.Key.LOGGEDIN_USER_ID, user.getId());

        if (request.isUserInRole("AGENT")) {
            logger.info(login + " has role AGENT");
            sessionBean.put(SessionBean.Key.LOGGEDIN_USERROLE, "AGENT");
        }
        if (request.isUserInRole("AEGON ACTIVE")) {
            logger.info(login + " has role AEGON ACTIVE");
            sessionBean.put(SessionBean.Key.LOGGEDIN_USERROLE, "AEGON ACTIVE");
        }
        if (request.isUserInRole("AGENT PREMIUM")) {
            logger.info(login + " has role AGENT PREMIUM");
            sessionBean.put(SessionBean.Key.LOGGEDIN_USERROLE, "AGENT PREMIUM");
        }
        if (request.isUserInRole("ADMIN")) {
            logger.info(login + " has role ADMIN");
            sessionBean.put(SessionBean.Key.LOGGEDIN_USERROLE, "ADMIN");
        }
    }

    /**
     * Wylogowuje użytkownika. Usuwa informacje o jego sesji i przenosi go na stronę logowania.
     *
     * @return
     */
    public String logout() {
        logger.info("LoginBean.logout - invoke");

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        // Zapisanie sesji, etc.
        sessionBean.logout();

        try {
            request.logout();
        } catch (ServletException e) {
            logger.log(Level.SEVERE, "LoginBean.logout - ServletException", e);
            return null;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "LoginBean.logout - error", e);
            return null;
        }

        return Navigation.LOGIN;
    }

    public void reset(ActionEvent event) {
        login = "";
        password = "";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UtilsBean getUtils() {
        return utils;
    }

    public void setUtils(UtilsBean utils) {
        this.utils = utils;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
