package pl.ksiegarnia.dao;

import javax.ejb.Local;
import javax.ejb.Remote;

import pl.ksiegarnia.dao.exception.DaoException;
import pl.ksiegarnia.jpa.Item;

@Local
public interface ItemDao {
	long createItem(Item item) throws DaoException;

	boolean updateItem(Item item) throws DaoException;

	Item getItemById(long id) throws DaoException;

	boolean deleteItem(long id) throws DaoException;
}
