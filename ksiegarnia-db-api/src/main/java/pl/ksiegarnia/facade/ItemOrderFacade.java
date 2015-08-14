package pl.ksiegarnia.facade;

import javax.ejb.Stateless;


import pl.ksiegarnia.dao.ItemOrderDao;
import pl.ksiegarnia.dao.exception.DaoException;
import pl.ksiegarnia.jpa.ItemOrder;

import java.util.logging.Logger;
//TODO dopisac logggi
@Stateless
public class ItemOrderFacade extends AbstractFacade implements ItemOrderDao {
	private static final Logger logger = Logger.getLogger(ItemOrderFacade.class.toString());

	public long createItemOrder(ItemOrder itemOrder) throws DaoException {
		logger.info("");
		try{
			entityManager.persist(itemOrder);
			return itemOrder.getId();
		}catch (Exception e){
			throw new DaoException(e);
		}
	}

	public boolean updateItemOrder(ItemOrder itemOrder) throws DaoException {
		logger.info("");
		try{
			entityManager.merge(itemOrder);
			return true;
		}catch (Exception e){
			throw new DaoException(e);
		}
	}



	public ItemOrder getItemOrderById(long itemOrderId) throws DaoException{

		logger.info("");
		try{
			ItemOrder itemOrder = entityManager.find(ItemOrder.class, itemOrderId);
			return itemOrder;
		}catch (Exception e){
			throw new DaoException(e);
		}
	}

	public boolean deleteItemOrder(long itemOrderId) throws DaoException {
		logger.info("");
		try{
			ItemOrder itemOrder = entityManager.find(ItemOrder.class, itemOrderId);
			entityManager.remove(itemOrder);
			return true;
		}catch (Exception e){
			throw new DaoException(e);
		}
	}


}
