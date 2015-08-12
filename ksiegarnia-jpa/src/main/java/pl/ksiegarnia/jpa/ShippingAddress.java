package pl.ksiegarnia.jpa;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(namespace = "http://localhost:8080/ksiegarnia/model", name = "ShippingAddress")
@Entity(name = "ShippingAddress")
@DiscriminatorValue("SHIPPING_ADDRESS")
public class ShippingAddress extends Address implements Serializable {

	private static final long serialVersionUID = 1775585176451620751L;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "shippingAddress", cascade = CascadeType.ALL)
	private Set<Order> orders = new HashSet<Order>();

	public ShippingAddress(String city, String postalCode, String street,
			Integer houseNumber, Integer apartmentNumber, String phone,
			Set<Order> orders) {
		super(city, postalCode, street, houseNumber, apartmentNumber, phone);
		this.orders = orders;
	}

	public ShippingAddress(Long id, String city, String postalCode,
			String street, Integer houseNumber, Integer apartmentNumber,
			String phone, Set<Order> orders) {
		super(id, city, postalCode, street, houseNumber, apartmentNumber, phone);
		this.orders = orders;
	}

	public ShippingAddress(String city, String postalCode, String street,
			Integer houseNumber, Integer apartmentNumber, String phone) {
		super(city, postalCode, street, houseNumber, apartmentNumber, phone);
	}

	public ShippingAddress() {
		super();
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
