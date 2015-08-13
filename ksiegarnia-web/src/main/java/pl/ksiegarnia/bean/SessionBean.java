package pl.ksiegarnia.bean;

import pl.ksiegarnia.dao.UserDao;
import pl.ksiegarnia.dao.exception.DaoException;
import pl.ksiegarnia.jpa.User;
import pl.ksiegarnia.utils.Navigation;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by pgrubarek on 11.08.15.
 */
@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {

    private static final long serialVersionUID = 1269009932781097810L;

    private static Logger logger = Logger.getLogger(SessionBean.class.toString());

    @EJB
    private UserDao userDao;

    private Map<Key, Object> map;

    public SessionBean() {

    }

    @PostConstruct
    public void init() {
        logger.info("SessionBean.init - invoke");

        map = new HashMap<Key, Object>();
    }

    public Object get(Key key) {
        return map.get(key);
    }

    public String getLoggedInRoleName() {
        return (String) map.get(Key.LOGGEDIN_USERROLE);
    }

    /**
     * Zwraca id obecnie zalogowanego użytkownika.
     */
    public long getLoggedInUserId() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        if (request.getRemoteUser() != null) {
            try {
                User user = userDao.getUserByLogin(request.getRemoteUser());

                return user.getId();
            } catch (DaoException e) {
                return 0;
            }
        }
        return 0;
    }



    /**
     * Zwraca login obecnie zalogowanego użytkownika.
     */
    public String getLoggedInUserLogin() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        if (request.getRemoteUser() != null) {
            return request.getRemoteUser();
        }

        return "";
    }

    public void login(String loginName) {
        put(Key.LOGGEDIN_USERNAME, loginName);
    }

    public void put(Key key, Object value) {
        if (key == Key.SELECTED_ITEM ) {
            logger.info("setting selectedMeeting: " + value);
        }
        map.put(key, value);
    }


    public boolean isLogged() {
        return map.containsKey(Key.LOGGEDIN_USERNAME);
    }

    public void showInfo(String title, String msg) {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(title, msg));
    }

    public void showInfo(String title, String msg, boolean keep) {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(keep);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(title, msg));
    }

    public void showError(String msg) {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd", msg));
    }

    public void showError(String title, String msg, boolean keep) {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(keep);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg));
    }

    public enum Key {
        LOGGEDIN_USERNAME,
        LOGGEDIN_USER_ID,
        LOGGEDIN_USERROLE,
        SELECTED_USER, //użytkownik/konto zaznaczony
        SELECTED_ITEM,
        MODE //tryb: EDIT lub VIEW lub NEW
    }

}