package pl.ksiegarnia.facade;

import pl.ksiegarnia.dao.AddressDao;
import pl.ksiegarnia.dao.exception.DaoException;
import pl.ksiegarnia.jpa.Address;

import javax.ejb.Stateless;
import java.util.logging.Logger;


@Stateless
public class AddressFacade extends AbstractFacade implements AddressDao {
    private static final Logger logger = Logger.getLogger(UserFacade.class.toString());
    public long createAddress(Address address) throws DaoException{
        logger.info("AddressFacade.createAddress - invoked");
        try{
            entityManager.persist(address);
            return address.getId();
        }catch (Exception e) {
            throw new DaoException(e);
        }
    }
    public boolean deleteAddress (long addressId) throws DaoException {
        logger.info("AddressFacade.deleteAddress - invoked");
        try{
            Address address = entityManager.find(Address.class, addressId);
            entityManager.remove(address);
            return true;
        }catch (Exception e){
            throw new DaoException(e);
        }
    }
    public boolean updateAddress (Address address) throws DaoException{
        logger.info("AddressFacade.updateAddress - invoked");
        try{
            entityManager.merge(address);
            return true;
        }catch (Exception e){
            throw new DaoException(e);
        }
    }
}
