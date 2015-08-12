package pl.ksiegarnia.jpa;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(namespace = "http://localhost:8080/ksiegarnia/model", name = "User")
@Entity(name = "User")
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 3448325390572648892L;

	public static final int STATUS_ACTIVE       = 1;
	public static final int __DEFAULT_STATUS    = STATUS_ACTIVE;
	public static final int STATUS_REMOVED      = 0;
	public static final int STATUS_BLOCKED      = 2;
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "usersSEQ", sequenceName = "users_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersSEQ")
	private Long id;

	@Column(name = "login", length = 40, nullable = false, unique = true)
	private String login;

	@Column(name = "password", length = 80, nullable = false, unique = false)
	private String password;



	// TODO trzeba dodac do bazy danych
	@Column(name = "password_salt", length = 80, nullable = false, unique = false)
	private String passwordSalt;

	@JsonIgnore
	@Column(name = "failed_attempts", nullable = true, unique = false)
	private Integer failedAttempts;

	@Column(name = "status", nullable = false, unique = false)
	private Integer status;
    //TODO dodac do bazy danych 3 pola


	@Column(name = "e_mail", length = 80, nullable = false, unique = true)
	private String eMail;

	@OneToOne(optional = true, cascade = CascadeType.ALL, targetEntity = UserAddress.class)
	@JoinColumn(name = "default_address_id")
	private UserAddress defaultAddress;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "owner", cascade = CascadeType.ALL)
	private Set<Order> orders = new HashSet<Order>();

	public User() {
		super();
	}

	public User(Long id, String login, String password, String eMail,
			UserAddress defaultAddress, Set<Order> orders) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.eMail = eMail;
		this.defaultAddress = defaultAddress;
		this.orders = orders;
	}

	public User(String login, String password, String eMail,
			UserAddress defaultAddress) {
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

	public void setDefaultAddress(UserAddress defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public String getPasswordSalt() {
		return passwordSalt;
	}

	public Integer getFailedAttempts() {
		return failedAttempts;
	}

	public void setFailedAttempts(Integer failedAttempts) {
		this.failedAttempts = failedAttempts;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public void incrementFailedAttempts() {
		this.failedAttempts++;
	}


	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	@Override
	public String toString() {
		return "pl.ksiegarnia.jpa.User [id=" + id + ", login=" + login + ", password=" + password
				+ ", eMail=" + eMail + "]";
	}



}
