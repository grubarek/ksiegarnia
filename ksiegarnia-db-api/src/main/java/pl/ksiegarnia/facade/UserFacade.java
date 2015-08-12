package pl.ksiegarnia.facade;

import pl.ksiegarnia.dao.UserDao;
import pl.ksiegarnia.dao.exception.DaoException;
import pl.ksiegarnia.jpa.User;

import javax.ejb.Stateless;
import java.util.logging.Logger;


@Stateless
public class UserFacade extends AbstractFacade implements UserDao {
    private static final Logger logger = Logger.getLogger(UserFacade.class.toString());
    public long createUser(User user)throws DaoException{
        logger.info("UserFacade.createUser - invoked");
        try{
            entityManager.persist(user);
            return user.getId();
        }catch (Exception e) {
            throw new DaoException(e);
        }
    }
    public boolean deleteUser(long userId) throws DaoException{
        logger.info("UserFacade.deleteUser - invoked");
        try{
            User user = entityManager.find(User.class, userId);
            entityManager.remove(user);
            return true;
        }catch (Exception e){
            throw new DaoException(e);
        }
    }

    public boolean updateUser(User user) throws DaoException{
        logger.info("UserFacade.updateUser - invoked");
        try{
            entityManager.merge(user);
            return true;
        }catch (Exception e){
            throw new DaoException(e);
        }
    }




}
