package ksiegarnia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(namespace = "http://localhost:8080/ksiegarnia/model", name = "Order")
@Entity(name = "ItemOrder")
@Table(name = "item_orders")
public class ItemOrder implements Serializable {
	private static final long serialVersionUID = 3448325390572648892L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "itemOrdersSEQ", sequenceName = "item_orders_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemOrdersSEQ")
	private Long id;

	@Column(name = "quantity", nullable = false, unique = false)
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Order owner;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;

	public ItemOrder() {
		super();
	}

	public ItemOrder(Long id, Integer quantity, Order owner, Item item) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.owner = owner;
		this.item = item;
	}

	public ItemOrder(Integer quantity, Order owner, Item item) {
		super();
		this.quantity = quantity;
		this.owner = owner;
		this.item = item;
	}

	@Override
	public String toString() {
		return "ItemOrder [id=" + id + ", quantity=" + quantity + ", owner="
				+ owner + ", item=" + item + "]";
	}

}
