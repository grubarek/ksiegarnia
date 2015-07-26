package ksiegarnia.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement
@XmlType(namespace = "http://localhost:8080/ksiegarnia/model", name = "User")
@Entity(name = "User")
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 3448325390572648892L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "usersSEQ", sequenceName = "users_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersSEQ")
	private Long id;

	@Column(name = "login", length = 40, nullable = false, unique = true)
	private String login;

	@Column(name = "password", length = 80, nullable = false, unique = false)
	private String password;

	@Column(name = "e_mail", length = 80, nullable = false, unique = true)
	private String eMail;

	@OneToOne(optional = true, cascade = CascadeType.ALL, targetEntity = UserAddress.class)
	@JoinColumn(name = "default_address_id")
	private Address defaultAddress;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "owner", cascade = CascadeType.ALL)
	private Set<Order> orders = new HashSet<Order>();

	public User() {
		super();
	}

	public User(Long id, String login, String password, String eMail,
			Address defaultAddress, Set<Order> orders) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.eMail = eMail;
		this.defaultAddress = defaultAddress;
		this.orders = orders;
	}

	public User(String login, String password, String eMail,
			Address defaultAddress) {
		super();
		this.login = login;
		this.password = password;
		this.eMail = eMail;
		this.defaultAddress = defaultAddress;
	}

	public User(String login, String password, String eMail) {
		super();
		this.login = login;
		this.password = password;
		this.eMail = eMail;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Address getDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(Address defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password
				+ ", eMail=" + eMail + ", defaultAddress=" + defaultAddress
				+ "]";
	}

}
