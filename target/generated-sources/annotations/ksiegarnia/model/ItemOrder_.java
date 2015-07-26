package ksiegarnia.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItemOrder.class)
public abstract class ItemOrder_ {

	public static volatile SingularAttribute<ItemOrder, Long> id;
	public static volatile SingularAttribute<ItemOrder, Item> item;
	public static volatile SingularAttribute<ItemOrder, Order> owner;
	public static volatile SingularAttribute<ItemOrder, Integer> quantity;

}

