package ksiegarnia.facade;

import ksiegarnia.dao.DaoException;
import ksiegarnia.dao.OrderDao;
import ksiegarnia.model.Order;

public class OrderFacade extends AbstractFacade implements OrderDao {
    public long createNewOrder(Order order) throws DaoException {
        try{
            em.persist(order);
            return order.getId();
        }catch (Exception e){
            throw new DaoException(e);
        }
    };

    public boolean deleteOrder(long orderId) throws DaoException{
        try{
            Order order = em.find(Order.class, orderId);
            em.remove(order);
            return true;
        }catch (Exception e){
            throw new DaoException(e);
        }
    };

    public boolean updateOrder(Order order) throws DaoException{
        try{
            em.merge(order);
            return true;
        }catch (Exception e){
            throw new DaoException(e);
        }
    };

    public Order getOrderById(long orderId) throws  DaoException{
        try{
            Order order = em.find(Order.class, orderId);
            order.getId();
            return order;
        }catch (Exception e){
            throw new DaoException(e);
        }
    };

}
