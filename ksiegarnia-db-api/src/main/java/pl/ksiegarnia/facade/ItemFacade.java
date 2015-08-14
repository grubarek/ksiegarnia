package pl.ksiegarnia.facade;

import javax.ejb.Stateless;
import pl.ksiegarnia.dao.ItemDao;
import pl.ksiegarnia.dao.exception.DaoException;
import pl.ksiegarnia.jpa.Item;

import java.util.logging.Logger;

@Stateless
public class ItemFacade extends AbstractFacade implements ItemDao {
	private static final Logger logger = Logger.getLogger(ItemFacade.class.toString());


	public long createItem(Item item) throws DaoException {
		logger.info("ItemFacade.createItem - invoked");
		try{
			entityManager.persist(item);
			return item.getId();
		}catch (Exception e) {
			throw  new DaoException(e);
		}
	}


	public boolean updateItem(Item item) throws DaoException {
		logger.info("ItemFacade.updateItem - invoked");
		try{
			entityManager.merge(item);
			return true;
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}



	public Item getItemById(long itemId) throws DaoException {
		logger.info("ItemFacade.getItem - invoked");
		try{
			Item item = entityManager.find(Item.class, itemId);
			return item;
		}catch (Exception e){
			throw  new DaoException(e);
		}

	}

	public boolean deleteItem(long itemId) throws DaoException {
		logger.info("ItemFacade.deleteItem - invoked");
		try{
			Item item = entityManager.find(Item.class, itemId);
			entityManager.remove(item);
			return true;
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}

}
