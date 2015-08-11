package ksiegarnia.dao;

import javax.ejb.Stateless;
import ksiegarnia.model.User;

@Stateless
public class UserFacade extends AbstractFacade implements  UserDao {

	
	
	@Override
	public long createUser(User user) throws Exception {
		logger.info(toString() + user);
		try {
			em.persist(user);
			return user.getId();
		} catch (Exception e) {
			logger.severe(toString() +  e);
		}
		return 0;
	}

	@Override
	public boolean deleteUser(long userId) throws DaoException{
		logger.info("delete user" + userId);
		try{
			User user = em.find(User.class, userId);
			em.remove(user);
			return true;
		}catch (Exception e){
			throw new DaoException(e);
		}
	}

	@Override
	public boolean updateUser(User user) throws DaoException{
		logger.info("updateUseer - invoked for: " + user.getLogin());
		try{
			em.merge(user);
			return true;
		}catch (Exception e){
			throw new DaoException(e);
		}
	}




}
