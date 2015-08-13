package pl.ksiegarnia.bean;

import pl.ksiegarnia.dao.BookDao;
import pl.ksiegarnia.dao.ItemDao;
import pl.ksiegarnia.dao.ItemOrderDao;
import pl.ksiegarnia.dao.UserDao;
import pl.ksiegarnia.jpa.Book;
import pl.ksiegarnia.jpa.Item;
import pl.ksiegarnia.jpa.User;
import pl.ksiegarnia.utils.UtilsBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import java.io.Serializable;
import java.util.List;
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











}
