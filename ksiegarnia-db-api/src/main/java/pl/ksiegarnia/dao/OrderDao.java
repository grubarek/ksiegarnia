package pl.ksiegarnia.dao;

import javax.ejb.Remote;

import ksiegarnia.model.Order;

@Remote
public interface OrderDao {
	long createOrder(Order order) throws Exception;

	boolean updateOrder(Order order) throws Exception;

	Order getOrder(long id);

	boolean deleteOrder(long id) throws Exception;
}
