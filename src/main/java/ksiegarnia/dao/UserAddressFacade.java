package ksiegarnia.dao;

import ksiegarnia.model.Address;

// implementacja metod dla interfejsu UserAdresDao
public class UserAddressFacade extends AbstractFacade implements UserAddressDao {

    @Override
    public String getAddress(Address address) throws Exception{
        String userAddress = null;
        try{
            em.persist(address);
            userAddress=em.toString();
        }catch (Exception e)
            {
                logger.severe(toString() +  e);
            }
        return userAddress;
    }
    @Override
    public long editAddress(Address address) throws Exception {
       //TODO
        return 0;
    }
}
