package ksiegarnia.model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, Long> id;
	public static volatile SingularAttribute<Order, String> methodOfShipping;
	public static volatile SetAttribute<Order, ItemOrder> itemOrders;
	public static volatile SingularAttribute<Order, User> owner;
	public static volatile SingularAttribute<Order, String> methodOfPayment;
	public static volatile SingularAttribute<Order, Date> date;
	public static volatile SingularAttribute<Order, ShippingAddress> shippingAddress;
	public static volatile SingularAttribute<Order, Boolean> isPaid;

}

