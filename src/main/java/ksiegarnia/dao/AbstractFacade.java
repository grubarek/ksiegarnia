package ksiegarnia.dao;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractFacade {
	
	protected Logger logger = Logger.getLogger(this.toString());
	
	@PersistenceContext(unitName="primary")
	protected EntityManager em;
	
	
	public EntityManager getEm() {
		return em;
	}
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
}
