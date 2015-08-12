package pl.ksiegarnia.facade;

import javax.ejb.Stateless;

import ksiegarnia.model.ShippingAddress;

@Stateless
public class ShippingAddressFacade extends AbstractFacade implements
		ShippingAddressDao {

	@Override
	public long createShippingAddress(ShippingAddress shippingAddress)
			throws Exception {
		return persistEntity(shippingAddress);
	}

	@Override
	public boolean updateShippingAddress(ShippingAddress shippingAddress)
			throws Exception {
		return mergeEntity(shippingAddress);
	}

	@Override
	public ShippingAddress getShippingAddress(long id) {

		return (ShippingAddress) findEntity(id, ShippingAddress.class);
	}

	@Override
	public boolean deleteShippingAddress(long id) throws Exception {

		return removeEntity(id, ShippingAddress.class);
	}

	@Override
	public String toString() {
		return "ShippingAddressFacade []";
	}

}
