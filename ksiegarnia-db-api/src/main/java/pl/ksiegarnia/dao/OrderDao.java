package pl.ksiegarnia.dao;

import pl.ksiegarnia.dao.exception.DaoException;
import pl.ksiegarnia.jpa.Order;

import javax.ejb.Local;
import java.util.logging.Logger;


@Local
public interface OrderDao {

	long createOrder(Order order) throws DaoException;

	boolean updateOrder(Order order) throws DaoException;

	Order getOrderById(long id) throws DaoException;

	boolean deleteOrder(long id) throws DaoException;
}
