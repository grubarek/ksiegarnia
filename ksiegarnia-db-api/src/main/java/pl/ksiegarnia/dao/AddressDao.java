package pl.ksiegarnia.dao;

import pl.ksiegarnia.dao.exception.DaoException;
import pl.ksiegarnia.jpa.Address;

import javax.ejb.Local;
import javax.ejb.Remote;

@Local
public interface AddressDao {
    public long createAddress(Address address) throws DaoException;
    public boolean deleteAddress (long addressId) throws DaoException;
    public boolean updateAddress (Address address) throws DaoException;
}
