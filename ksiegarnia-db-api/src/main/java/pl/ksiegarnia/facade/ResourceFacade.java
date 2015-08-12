package pl.ksiegarnia.facade;

import pl.oneapp.aegon.dao.ResourceDao;
import pl.oneapp.aegon.dao.exception.DaoException;
import pl.oneapp.aegon.jpa.Resource;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class ResourceFacade extends AbstractFacade implements ResourceDao {
    private static final Logger logger = Logger.getLogger(ResourceFacade.class.toString());

    public long createResource(Resource resource) throws DaoException {
        logger.info("ResourceFacade.createResource - invoked");
        try {
            entityManager.persist(resource);
            return resource.getId();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public boolean updateResource(Resource resource) throws DaoException {
        logger.info("ResourceFacade.updateResource - invoked");
        try {
            entityManager.merge(resource);
            return true;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public boolean deleteResource(long resourceId) throws DaoException {
        logger.info("ResourceFacade.deleteResource - invoked");
        try {
            Resource resource = entityManager.find(Resource.class, resourceId);
            entityManager.remove(resource);
            return true;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public long getCounterOfResources() throws DaoException {
        logger.info("ResourceFacade.getCounterOfResources - invoked");
        try {
            Query query = entityManager.createQuery("SELECT count(x) FROM Resource x");
            Number n = (Number) query.getSingleResult();
            return n.longValue();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public List<Resource> getListOfResources(int offset, int limit) throws DaoException {
        logger.info("ResourceFacade.getListOfResources - invoked");
        try {
            TypedQuery<Resource> query = entityManager.createQuery("SELECT x FROM Resource x", Resource.class);
            query.setFirstResult(offset).setMaxResults(limit);
            return query.getResultList();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Resource getResourceById(long resourceId) throws DaoException {
        logger.info("ResourceFacade.getResourceById - invoked");
        try {
            return entityManager.find(Resource.class, resourceId);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}