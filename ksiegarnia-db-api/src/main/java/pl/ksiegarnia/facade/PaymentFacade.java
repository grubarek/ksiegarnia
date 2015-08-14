package pl.ksiegarnia.facade;


import pl.ksiegarnia.dao.PaymentDao;

import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class PaymentFacade extends AbstractFacade implements PaymentDao {
    private static final Logger logger = Logger.getLogger(PaymentFacade.class.toString());

   }