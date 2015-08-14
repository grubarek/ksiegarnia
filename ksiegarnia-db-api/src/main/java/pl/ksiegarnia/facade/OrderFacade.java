package pl.ksiegarnia.facade;

import pl.ksiegarnia.dao.OrderDao;
import pl.ksiegarnia.dao.exception.DaoException;
import pl.ksiegarnia.jpa.Order;

import javax.ejb.Stateless;
import java.util.logging.Logger;

//TODO dopisac logi
@Stateless
public class OrderFacade extends AbstractFacade implements OrderDao {
	private static final Logger logger = Logger.getLogger(OrderFacade.class.toString());

	public long createOrder(Order order) throws DaoException {
		logger.info("");
		try{
			entityManager.persist(order);
			return order.getId();
		}catch (Exception e){
			throw new DaoException(e);
		}

	}

	public boolean updateOrder(Order order) throws DaoException {
		logger.info("");
		try{
			entityManager.merge(order);
			return true;
		}catch (Exception e){
			throw new DaoException(e);
		}
	}


	public Order getOrderById(long orderId) throws DaoException {

		logger.info("");
		try{
			Order order = entityManager.find(Order.class,orderId);
			return order;
		}catch (Exception e){
			throw new DaoException(e);
		}
	}


	public boolean deleteOrder(long orderId) throws DaoException {
		logger.info("");
		try{
			Order order = entityManager.find(Order.class, orderId);
			entityManager.remove(order);
			return true;
		}catch (Exception e){
			throw new DaoException(e);
		}
	}



}
