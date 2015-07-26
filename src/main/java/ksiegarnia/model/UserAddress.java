package ksiegarnia.model;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(namespace = "http://localhost:8080/ksiegarnia/model", name = "UserAddress")
@Entity(name = "UserAddress")
@DiscriminatorValue("USER_ADDRESS")
public class UserAddress extends Address implements Serializable {


	private static final long serialVersionUID = -5444174513763998952L;
	
	@OneToOne(mappedBy = "defaultAddress", optional = true)
	private User owner;

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "UserAddress [owner=" + owner + ", id=" + id + ", city=" + city
				+ ", postalCode=" + postalCode + ", street=" + street
				+ ", houseNumber=" + houseNumber + ", apartmentNumber="
				+ apartmentNumber + ", phone=" + phone + "]";
	}

	public UserAddress(Long id, String city, String postalCode, String street,
			Integer houseNumber, Integer apartmentNumber, String phone,
			User owner) {
		super(id, city, postalCode, street, houseNumber, apartmentNumber, phone);
		this.owner = owner;
	}

	public UserAddress(String city, String postalCode, String street,
			Integer houseNumber, Integer apartmentNumber, String phone,
			User owner) {
		super(city, postalCode, street, houseNumber, apartmentNumber, phone);
		this.owner = owner;
	}

	public UserAddress( String city, String postalCode, String street,
			Integer houseNumber, Integer apartmentNumber, String phone) {
		super( city, postalCode, street, houseNumber, apartmentNumber, phone);
	}

	public UserAddress() {
		super();
	}

}
