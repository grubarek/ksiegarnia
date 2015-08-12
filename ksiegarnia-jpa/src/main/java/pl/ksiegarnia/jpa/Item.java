package pl.ksiegarnia.jpa;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(namespace = "http://localhost:8080/ksiegarnia/model", name = "Item")
@Entity(name = "Item")
@Table(name = "items")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="item_type",discriminatorType=DiscriminatorType.STRING,length=20)
public abstract class Item implements Serializable {
	private static final long serialVersionUID = 3448325390572648892L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "itemsSEQ", sequenceName = "items_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemsSEQ")
	private Long id;

	@Column(name = "price", nullable = false, unique = false)
	private Double price;
	
	@Column(name = "quantity", nullable = false, unique = false)
	private Integer quantity;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "item", cascade = CascadeType.ALL)
	private Set<ItemOrder> itemOrders=new HashSet<ItemOrder>();

	public Item(Long id, Double price, Integer quantity,
			Set<ItemOrder> itemOrders) {
		super();
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.itemOrders = itemOrders;
	}

	public Item() {
		super();
	}

	public Item(Double price, Integer quantity) {
		super();
		this.price = price;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Set<ItemOrder> getItemOrders() {
		return itemOrders;
	}

	public void setItemOrders(Set<ItemOrder> itemOrders) {
		this.itemOrders = itemOrders;
	}

	@Override
	public String toString() {
		return "pl.ksiegarnia.jpa.Item [id=" + id + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}


	
}
