package pl.ksiegarnia.facade;

import pl.oneapp.aegon.dao.ResourceTypeDao;
import pl.oneapp.aegon.dao.exception.DaoException;
import pl.oneapp.aegon.jpa.ResourceType;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class ResourceTypeFacade extends AbstractFacade implements ResourceTypeDao {
    private static final Logger logger = Logger.getLogger(ResourceTypeFacade.class.toString());

    public long createResourceType(ResourceType resourceType) throws DaoException {
        logger.info("ResourceTypeFacade.createResourceType - invoked");
        try {
            entityManager.persist(resourceType);
            return resourceType.getId();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public boolean updateResourceType(ResourceType resourceType) throws DaoException {
        logger.info("ResourceTypeFacade.updateResourceType - invoked");
        try {
            entityManager.merge(resourceType);
            return true;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public boolean deleteResourceType(long resourceTypeId) throws DaoException {
        logger.info("ResourceTypeFacade.deleteResourceType - invoked");
        try {
            ResourceType resourceType = entityManager.find(ResourceType.class, resourceTypeId);
            entityManager.remove(resourceType);
            return true;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public long getCounterOfResourceTypes() throws DaoException {
        logger.info("ResourceTypeFacade.getCounterOfResourceTypes - invoked");
        try {
            Query query = entityManager.createQuery("SELECT count(x) FROM ResourceType x");
            Number n = (Number) query.getSingleResult();
            return n.longValue();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public List<ResourceType> getListOfResourceTypes(int offset, int limit) throws DaoException {
        logger.info("ResourceTypeFacade.getListOfResourceTypes - invoked");
        try {
            TypedQuery<ResourceType> query = entityManager.createQuery("SELECT x FROM ResourceType x", ResourceType.class);
            query.setFirstResult(offset).setMaxResults(limit);
            return query.getResultList();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public ResourceType getResourceTypeById(long resourceTypeId) throws DaoException {
        logger.info("ResourceTypeFacade.getResourceTypeById - invoked");
        try {
            return entityManager.find(ResourceType.class, resourceTypeId);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

	public ResourceType getResourceTypeByName(String name) throws DaoException {
		logger.info(String.format("ResourceTypeFacade.getResourceTypeByName - invoked, name = %s", name));
		if (name == null) {
			logger.warning("ResourceTypeFacade.getResourceTypeByName name is NULL!");
			return null;
		}
		try {
			TypedQuery<ResourceType> query = entityManager.createQuery("SELECT x FROM ResourceType x WHERE lower(name) = :name", ResourceType.class);
			query.setParameter("name", name.toLowerCase());
			return query.getSingleResult();
		} catch (NoResultException e) {
			logger.warning(String.format("ResourceTypeFacade.getResourceTypeByName, warning, no such type: %s", name));
			return null;
		} catch (Exception e) {
			logger.warning(String.format("ResourceTypeFacade.getResourceTypeByName error: %s", e));
			throw new DaoException(e);
		}
	}

}