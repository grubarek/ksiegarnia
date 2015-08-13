package pl.ksiegarnia.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(namespace = "http://localhost:8080/ksiegarnia/pl.ksiegarnia.model", name = "Address")
@Entity(name = "Address")
@Table(name = "addresses")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="address_type",discriminatorType=DiscriminatorType.STRING,length=20)
public class Address implements Serializable {
	protected static final long serialVersionUID = 3448325390572648892L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "addressesSEQ", sequenceName = "addresses_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressesSEQ")
	protected Long id;

	@Column(name = "city", length = 80, nullable = false, unique = false)
	protected String city;

	@Column(name = "postal_code", length = 6, nullable = false, unique = false)
	protected String postalCode;

	@Column(name = "street", length = 80, nullable = false, unique = false)
	protected String street;

	@Column(name = "house_number", nullable = false, unique = false)
	protected Integer houseNumber;

	@Column(name = "apartment_number", nullable = true, unique = false)
	protected Integer apartmentNumber;

	@Column(name = "phone", length = 20, nullable = false, unique = false)
	protected String phone;

	public Address() {
		super();
	}

	public Address(Long id, String city, String postalCode, String street,
			Integer houseNumber, Integer apartmentNumber, String phone) {
		super();
		this.id = id;
		this.city = city;
		this.postalCode = postalCode;
		this.street = street;
		this.houseNumber = houseNumber;
		this.apartmentNumber = apartmentNumber;
		this.phone = phone;
	}

	public Address(String city, String postalCode, String street,
			Integer houseNumber, Integer apartmentNumber, String phone) {
		super();
		this.city = city;
		this.postalCode = postalCode;
		this.street = street;
		this.houseNumber = houseNumber;
		this.apartmentNumber = apartmentNumber;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}

	public Integer getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(Integer apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "pl.ksiegarnia.jpa.Address [id=" + id + ", city=" + city + ", postalCode="
				+ postalCode + ", street=" + street + ", houseNumber="
				+ houseNumber + ", apartmentNumber=" + apartmentNumber
				+ ", phone=" + phone + "]";
	}




	

}
