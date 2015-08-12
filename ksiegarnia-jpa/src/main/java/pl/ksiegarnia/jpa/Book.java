package pl.ksiegarnia.jpa;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(namespace = "http://localhost:8080/ksiegarnia/model", name = "Book")
@Entity(name = "pl.ksiegarnia.jpa.Book")
@Table(name = "books")
@DiscriminatorValue("BOOK")
public class Book extends Item implements Serializable {
	private static final long serialVersionUID = 3448325390572648892L;




	@Column(name = "author", length = 80, nullable = false, unique = false)
	private String author;
	
	@Column(name = "title", length = 80, nullable = false, unique = false)
	private String title;
	
	@Column(name = "description", length = 1000, nullable = false, unique = false)
	private String description;

	public Book(Long id, Double price, Integer quantity,
			Set<ItemOrder> itemOrders, String author, String title,
			String description) {
		super(id, price, quantity, itemOrders);
		this.author = author;
		this.title = title;
		this.description = description;
	}

	public Book(Long id, Double price, Integer quantity,
			Set<ItemOrder> itemOrders) {
		super(id, price, quantity, itemOrders);
	}

	public Book(Double price, Integer quantity, String author, String title,
			String description) {
		super(price, quantity);
		this.author = author;
		this.title = title;
		this.description = description;
	}

	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "pl.ksiegarnia.jpa.Book [author=" + author + ", title=" + title + ", description="
				+ description + "]";
	}
	


}
