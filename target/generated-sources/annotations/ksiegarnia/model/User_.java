package ksiegarnia.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, UserAddress> defaultAddress;
	public static volatile SingularAttribute<User, String> eMail;
	public static volatile SetAttribute<User, Order> orders;
	public static volatile SingularAttribute<User, String> login;
	public static volatile SingularAttribute<User, String> password;

}

