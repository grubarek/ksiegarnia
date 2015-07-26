package ksiegarnia.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Address.class)
public abstract class Address_ {

	public static volatile SingularAttribute<Address, Long> id;
	public static volatile SingularAttribute<Address, String> phone;
	public static volatile SingularAttribute<Address, String> postalCode;
	public static volatile SingularAttribute<Address, Integer> apartmentNumber;
	public static volatile SingularAttribute<Address, String> street;
	public static volatile SingularAttribute<Address, Integer> houseNumber;
	public static volatile SingularAttribute<Address, String> city;

}

