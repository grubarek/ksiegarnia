package pl.ksiegarnia.dao;

import pl.ksiegarnia.dao.exception.DaoException;
import pl.ksiegarnia.jpa.User;

import javax.ejb.Local;



@Local
public interface UserDao {

    public long createUser(User user)throws DaoException;
    public boolean deleteUser(long userId) throws DaoException;
    public boolean updateUser(User user) throws DaoException;

}
