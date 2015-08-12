package pl.ksiegarnia.jpa;

import java.io.Serializable;
import java.sql.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(namespace = "http://localhost:8080/ksiegarnia/model", name = "Order")
@Entity(name = "pl.ksiegarnia.jpa.Order")
@Table(name = "orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 3448325390572648892L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "ordersSEQ", sequenceName = "orders_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordersSEQ")
	private Long id;

	@Column(name = "date", nullable = false, unique = false)
	private Date date;

	@Column(name = "is_paid", nullable = false, unique = false)
	private Boolean isPaid;
	
	@Column(name = "method_of_payment",length = 80, nullable = false, unique = false)
	private String methodOfPayment;
	
	@Column(name = "method_of_shipping", length = 80, nullable = false, unique = false)
	private String methodOfShipping;

	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private User owner;
	
	@ManyToOne
	@JoinColumn(name = "shipping_address_id")	
	private ShippingAddress shippingAddress;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "owner", cascade = CascadeType.ALL)
	private Set<ItemOrder> itemOrders=new HashSet<ItemOrder>();

	public Order() {
		super();
	}

	public Order(Long id, Date date, Boolean isPaid, String methodOfPayment,
			String methodOfShipping, User owner, ShippingAddress shippingAddress,
			Set<ItemOrder> itemOrders) {
		super();
		this.id = id;
		this.date = date;
		this.isPaid = isPaid;
		this.methodOfPayment = methodOfPayment;
		this.methodOfShipping = methodOfShipping;
		this.owner = owner;
		this.shippingAddress = shippingAddress;
		this.itemOrders = itemOrders;
	}

	public Order(Date date, Boolean isPaid, String methodOfPayment,
			String methodOfShipping, User owner, ShippingAddress shippingAddress) {
		super();
		this.date = date;
		this.isPaid = isPaid;
		this.methodOfPayment = methodOfPayment;
		this.methodOfShipping = methodOfShipping;
		this.owner = owner;
		this.shippingAddress = shippingAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}

	public String getMethodOfPayment() {
		return methodOfPayment;
	}

	public void setMethodOfPayment(String methodOfPayment) {
		this.methodOfPayment = methodOfPayment;
	}

	public String getMethodOfShipping() {
		return methodOfShipping;
	}

	public void setMethodOfShipping(String methodOfShipping) {
		this.methodOfShipping = methodOfShipping;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Set<ItemOrder> getItemOrders() {
		return itemOrders;
	}

	public void setItemOrders(Set<ItemOrder> itemOrders) {
		this.itemOrders = itemOrders;
	}

	@Override
	public String toString() {
		return "pl.ksiegarnia.jpa.Order [id=" + id + ", date=" + date + ", isPaid=" + isPaid
				+ ", methodOfPayment=" + methodOfPayment
				+ ", methodOfShipping=" + methodOfShipping + "]";
	}








}
