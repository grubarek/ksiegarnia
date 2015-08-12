package pl.ksiegarnia.facade;

import pl.oneapp.aegon.dao.RoleDao;
import pl.oneapp.aegon.dao.exception.DaoException;
import pl.oneapp.aegon.jpa.Role;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class RoleFacade extends AbstractFacade implements RoleDao {
    private static final Logger logger = Logger.getLogger(RoleFacade.class.toString());

    public long createRole(Role role) throws DaoException {
        logger.info("RoleFacade.createRole - invoked");
        try {
            entityManager.persist(role);
            return role.getId();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public boolean updateRole(Role role) throws DaoException {
        logger.info("RoleFacade.updateRole - invoked");
        try {
            entityManager.merge(role);
            return true;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public boolean deleteRole(long roleId) throws DaoException {
        logger.info("RoleFacade.deleteRole - invoked");
        try {
            Role role = entityManager.find(Role.class, roleId);
            entityManager.remove(role);
            return true;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public long getCounterOfRoles() throws DaoException {
        logger.info("RoleFacade.getCounterOfRoles - invoked");
        try {
            Query query = entityManager.createQuery("SELECT count(x) FROM Role x");
            Number n = (Number) query.getSingleResult();
            return n.longValue();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public List<Role> getListOfRoles(int offset, int limit) throws DaoException {
        logger.info("RoleFacade.getListOfRoles - invoked");
        try {
            TypedQuery<Role> query = entityManager.createQuery("SELECT x FROM Role x", Role.class);
            query.setFirstResult(offset).setMaxResults(limit);
            return query.getResultList();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Role getRoleById(long roleId) throws DaoException {
        logger.info("RoleFacade.getRoleById - invoked");
        try {
            return entityManager.find(Role.class, roleId);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

	@Override
	public List<Role> getAccountRoles(long accountId) throws DaoException {
 	    logger.info(String.format("RoleFacade.getAccountRoles - invoked, account id=%d", accountId));
		try {
			TypedQuery<Role> query = entityManager.createNamedQuery("Role.getUserRoles", Role.class);
			query.setParameter("accountId", accountId);
			return query.getResultList();
        } catch(Exception e) {
	        throw new DaoException(e);
        }
	}
}