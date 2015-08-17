package pl.ksiegarnia.rest.manager;

import pl.ksiegarnia.rest.model.Item;

/**
 * Created by pgrubarek on 17.08.15.
 */
public interface iItem {


    public Item create(Item item);
    public Item edit(Item item);
}
