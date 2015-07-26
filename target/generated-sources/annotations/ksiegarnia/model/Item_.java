package ksiegarnia.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Item.class)
public abstract class Item_ {

	public static volatile SingularAttribute<Item, Long> id;
	public static volatile SingularAttribute<Item, Double> price;
	public static volatile SetAttribute<Item, ItemOrder> itemOrders;
	public static volatile SingularAttribute<Item, Integer> quantity;

}

