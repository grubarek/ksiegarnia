package pl.ksiegarnia.rest.model;

import pl.ksiegarnia.jpa.*;

import java.io.Serializable;

/**
 * Created by pgrubarek on 17.08.15.
 */
public class Book extends Item implements Serializable {

    private static final long serialVersionUID = 4764932857572648892L;

    private String author;
    private String title;
    private String description;

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



    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
