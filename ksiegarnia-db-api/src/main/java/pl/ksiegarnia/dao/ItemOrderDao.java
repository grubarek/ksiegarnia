package pl.ksiegarnia.dao;

import pl.ksiegarnia.dao.exception.DaoException;
import pl.ksiegarnia.jpa.ItemOrder;

import javax.ejb.Remote;



@Remote
public interface ItemOrderDao {
	long createItemOrder(ItemOrder itemOrder) throws Exception;

	boolean updateItemOrder(ItemOrder ItemOrder) throws DaoException;

	ItemOrder getItemOrderById(long id) throws DaoException;

	boolean deleteItemOrder(long id) throws Exception;
}
