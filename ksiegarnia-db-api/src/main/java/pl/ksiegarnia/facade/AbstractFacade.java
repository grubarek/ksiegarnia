package pl.ksiegarnia.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by skywalker on 04.06.14.
 */
public abstract class AbstractFacade {

    @PersistenceContext(unitName ="AegonUnit")
    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
