package ksiegarnia.dao;

import ksiegarnia.model.Order;

public interface OrderDao {
    public long createNewOrder(Order order) throws DaoException;
    public boolean deleteOrder(long orderId) throws DaoException;
    public boolean updateOrder(Order order) throws DaoException;
    public Order getOrderById(long orderId) throws  DaoException;

}
