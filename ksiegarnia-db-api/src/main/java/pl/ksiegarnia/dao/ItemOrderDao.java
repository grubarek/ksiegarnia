package pl.ksiegarnia.dao;

import javax.ejb.Remote;

import ksiegarnia.model.ItemOrder;

@Remote
public interface ItemOrderDao {
	long createItemOrder(ItemOrder itemOrder) throws Exception;

	boolean updateItemOrder(ItemOrder ItemOrder) throws Exception;

	ItemOrder getItemOrder(long id);

	boolean deleteItemOrder(long id) throws Exception;
}
