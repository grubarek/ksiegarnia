package pl.ksiegarnia.facade;

import javax.ejb.Stateless;

import ksiegarnia.model.Order;

@Stateless
public class OrderFacade extends AbstractFacade implements OrderDao {
	
	@Override
	public long createOrder(Order order) throws Exception {
		return persistEntity(order);
	}	@Override
	public boolean updateOrder(Order order) throws Exception {
		return mergeEntity(order);
	}



	@Override
	public Order getOrder(long id) {

		return (Order) findEntity(id, Order.class);
	}

	@Override
	public boolean deleteOrder(long id) throws Exception {

		return removeEntity(id, Order.class);
	}
	@Override
	public String toString() {
		return "OrderFacade []";
	}

}
