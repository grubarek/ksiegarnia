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
	public String toString() {
		return "UserFacade []";
	}
	


}
