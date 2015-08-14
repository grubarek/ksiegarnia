package pl.ksiegarnia.facade;

import org.apache.commons.codec.digest.DigestUtils;
import pl.ksiegarnia.configuration.Configuration;
import pl.ksiegarnia.dao.UserDao;
import pl.ksiegarnia.dao.exception.DaoException;
import pl.ksiegarnia.jpa.User;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
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
    public User getUserById(long userId) throws DaoException{
        logger.info("UserFacade.getUserById - invoked");
        try{
            User user = entityManager.find(User.class, userId);
            return user;
        }catch (Exception e){
            throw new DaoException(e);
        }
    }

    public User getUserByLogin(String login) throws DaoException{
        logger.info(String.format("UserFacade.getUserByLogin - invoked, login=%s", login));
        try {
            TypedQuery<User> query = entityManager.createQuery("SELECT x FROM User x WHERE x.login = :login", User.class);
            query.setParameter("login", login);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public User authorize(String login, String password) {
        logger.info(String.format("AccountFacade.authorize - invoked, login=%s", login));
        try {
            User user = getUserByLogin(login);
            if (user == null) {
                logger.info("authorize, no such user: " + login);
                return null;
            }
            String hash = DigestUtils.shaHex(user.getPasswordSalt() + password);
            if (hash.equalsIgnoreCase(user.getPassword())) {
                logger.info("authorize, user authorized");

                updateUser(user);
                return user;
            } else {
                checkBlockedUser(user);
                logger.info("authorize, wrong password");
            }

        } catch (Exception e) {
            logger.warning("authorize, exception: " + e);
        }
        return null;
    }
    private boolean checkBlockedUser(User user) {
        logger.info(String.format("checkBlockAccount for user %s, current failed attempts:", user.getLogin()));
        try {
            user.incrementFailedAttempts();
            updateUser(user);
            if (user.getFailedAttempts() >= Configuration.WRONG_LOGIN_COUNT) {
                logger.info(String.format("Account %s was blocked.", user.getLogin()));
                user.setStatus(user.STATUS_BLOCKED);   //TODO dodac do tabelil
                updateUser(user);
                return true;
            }
        } catch (Exception e) {
            logger.warning("checkBlockAccount error: " + e);
        }
        return false;
    }




}
