package pl.ksiegarnia.jpa;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(namespace = "http://localhost:8080/ksiegarnia/pl.ksiegarnia.model", name = "Book")
@Entity(name = "Book")
@Table(name = "books")
@DiscriminatorValue("BOOK")
public class Book implements Serializable {
	private static final long serialVersionUID = 3448325390572648892L;
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "itemsSEQ", sequenceName = "items_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemsSEQ")
	private Long id;

	@Column(name = "author", length = 80, nullable = false, unique = false)
	private String author;
	
	@Column(name = "title", length = 80, nullable = false, unique = false)
	private String title;
	
	@Column(name = "description", length = 1000, nullable = false, unique = false)
	private String description;

	@Column(name = "price", nullable = false, unique = false)
	private Double price;

	@Column(name = "quantity", nullable = false, unique = false)
	private Integer quantity;

	@Column(name = "book_type", length = 40, nullable = false, unique = false)
	private String book_type;

	public Book() {
	}


	public Book(String title, String description, Double price, Integer quantity, String book_type, String author) {
		this.title = title;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.book_type = book_type;
		this.author = author;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getBook_type() {
		return book_type;
	}

	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", author='" + author + '\'' +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", quantity=" + quantity +
				", book_type='" + book_type + '\'' +
				'}';
	}
}
