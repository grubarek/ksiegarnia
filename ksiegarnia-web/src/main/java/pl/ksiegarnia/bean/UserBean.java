package pl.ksiegarnia.bean;

import org.primefaces.component.sticky.Sticky;
import pl.ksiegarnia.dao.BookDao;
import pl.ksiegarnia.dao.ItemDao;
import pl.ksiegarnia.dao.ItemOrderDao;
import pl.ksiegarnia.dao.UserDao;
import pl.ksiegarnia.jpa.Book;
import pl.ksiegarnia.jpa.Item;
import pl.ksiegarnia.jpa.User;
import pl.ksiegarnia.utils.UtilsBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by pgrubarek on 11.08.15.
 */
public class UserBean implements Serializable{
    private static final long serialVersionUID = -7603349152920549746L;
    private static Logger logger = Logger.getLogger(UserBean.class.toString());

    @EJB
    UserDao userDao;

    @EJB
    ItemOrderDao itemOrderDao;

    @EJB
    ItemDao itemDao;

    @EJB
    BookDao bookDao;

    private User selectedUser;
    private Long selectedUserId;
    private List<User> users;
    private Item selectedItem;
    private Long selectedItemId;
    private List<Item> items;
    private Book selectedBook;
    private Long selectedBookId;
    private List<Book> books;

    /**
     * id konta do edycji - przekazywane getem
     */
    private Long accountId;

    @ManagedProperty(value = "#{userBean}")
    private SessionBean sessionBean;

    @ManagedProperty(value = "#{utilsBean}")
    private UtilsBean utilsBean;

    @PostConstruct
    public void init() {
        logger.info("UserBean.init invoked");

        String login = (String) sessionBean.get(SessionBean.Key.LOGGEDIN_USERNAME);

        try {
            selectedUser = (User) sessionBean.get(SessionBean.Key.SELECTED_USER);

        }catch (Exception e) {
            logger.log(Level.SEVERE, "UserBean.init: ", e);
        }
    }

    public Long getAccountId() {
        return accountId;
    }
    public List<Book> getBooks(){
        try{
            return bookDao.list(0,1000);
        }catch (Exception e){
            logger.warning(String.format("getBooks err: %s", e));
            return null;
        }
    }


}
