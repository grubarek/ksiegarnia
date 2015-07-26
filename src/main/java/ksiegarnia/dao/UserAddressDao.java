package ksiegarnia.dao;

import ksiegarnia.model.Address;

public interface UserAddressDao {
    public String getAddress(Address address) throws Exception;
    public long editAddress(Address address) throws Exception;
}
