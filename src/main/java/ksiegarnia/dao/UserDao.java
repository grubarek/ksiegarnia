package ksiegarnia.dao;

import javax.ejb.Remote;

import ksiegarnia.model.*;


@Remote
public interface UserDao {
	long createUser(User user) throws Exception;
	boolean deleteUser(long userId) throws DaoException;
	boolean updateUser(User user) throws DaoException;
	//public boolean
	
}
