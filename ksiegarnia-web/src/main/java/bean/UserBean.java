package bean;

import ksiegarnia.dao.BookDao;
import ksiegarnia.dao.ItemDao;
import ksiegarnia.dao.OrderDao;
import ksiegarnia.dao.UserDao;
import ksiegarnia.model.Book;
import ksiegarnia.model.Item;
import ksiegarnia.model.Order;
import ksiegarnia.model.User;

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
    BookDao bookDao;

    @EJB
    ItemDao itemDao;

    @EJB
    OrderDao orderDao;


    private User selectedUser;
    private long selectedUserId;
    private Item selectedItem;
    private long selectedItemId;
    private Order selectedOrder;
    private long selectedOrderId;
    private Book selectedBook;
    private long selectedBookId;

    private List<Book>  booksList;
    private List<User> userList;
    private List<Order> orderList;

    private String password, pasword2;

    private Long userId;
    @ManagedProperty(value = "#{sessionBean}")
    private SeasonBean seasonBean;


}
