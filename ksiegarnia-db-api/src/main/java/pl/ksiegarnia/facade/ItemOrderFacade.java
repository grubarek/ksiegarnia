package pl.ksiegarnia.facade;

import javax.ejb.Stateless;

import ksiegarnia.model.ItemOrder;

@Stateless
public class ItemOrderFacade extends AbstractFacade implements ItemOrderDao {
	
	@Override
	public long createItemOrder(ItemOrder itemOrder) throws Exception {
		return persistEntity(itemOrder);
	}	@Override
	public boolean updateItemOrder(ItemOrder itemOrder) throws Exception {
		return mergeEntity(itemOrder);
	}



	@Override
	public ItemOrder getItemOrder(long id) {

		return (ItemOrder) findEntity(id, ItemOrder.class);
	}

	@Override
	public boolean deleteItemOrder(long id) throws Exception {

		return removeEntity(id, ItemOrder.class);
	}
	@Override
	public String toString() {
		return "ItemOrderFacade []";
	}

}
