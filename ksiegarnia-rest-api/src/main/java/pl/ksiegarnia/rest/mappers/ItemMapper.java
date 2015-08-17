package pl.ksiegarnia.rest.mappers;

import pl.ksiegarnia.jpa.Item;

import java.util.logging.Logger;

/**
 * Created by pgrubarek on 17.08.15.
 */
public class ItemMapper {
    public static final Logger logger = Logger.getLogger("ItemMapper");

    public static pl.ksiegarnia.rest.model.Item mapItemJPAToItemREST(Item itemJPA){
        pl.ksiegarnia.rest.model.Item itemREST = new pl.ksiegarnia.rest.model.Item();
        itemREST.setId(itemJPA.getId());  // mapuje id resta -> id jpa
        itemREST.setPrice(itemJPA.getPrice()); // rest price -> jpa price
        itemREST.setQuantity(itemJPA.getQuantity());
        return itemREST;
    }

}
