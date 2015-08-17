package pl.ksiegarnia.rest.manager;

import pl.ksiegarnia.dao.ItemDao;
import pl.ksiegarnia.dao.exception.DaoException;
import pl.ksiegarnia.rest.model.Item;

import javax.ejb.EJB;
import java.util.logging.Logger;

/**
 * Created by pgrubarek on 17.08.15.
 */
public class ItemManager implements iItem {
    private static final Logger logger = Logger.getLogger(ItemManager.class.toString());

    @EJB
    private ItemDao itemDao;



    @Override
    public Item create(Item item) {
        pl.ksiegarnia.jpa.Item itemJPA = null;
        logger.info("ItemManager.create - invoked");
        try {
            itemJPA = itemDao.createItem(item.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Item edit(Item item) {
        pl.ksiegarnia.jpa.Item itemJPA = null;
        logger.info("ItemManager.edit - invoked");
        return null;
    }



}
