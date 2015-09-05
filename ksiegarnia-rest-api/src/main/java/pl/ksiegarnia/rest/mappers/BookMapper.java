package pl.ksiegarnia.rest.mappers;

import pl.ksiegarnia.jpa.Item;
import pl.ksiegarnia.rest.model.Book;

import java.util.logging.Logger;

/**
 * Created by pgrubarek on 17.08.15.
 */
public class BookMapper {
    public static final Logger logger = Logger.getLogger("BookMapper");
    public static pl.ksiegarnia.rest.model.Book mapBookJPAToBookREST(pl.ksiegarnia.jpa.Book bookJPA){

        pl.ksiegarnia.rest.model.Book bookREST = new pl.ksiegarnia.rest.model.Book();
        bookREST.setAuthor(bookJPA.getAuthor());
        bookREST.setTitle(bookJPA.getTitle());
        bookREST.setDescription(bookJPA.getDescription());
        bookREST.setPrice(bookJPA.getPrice());
        bookREST.setQuantity(bookJPA.getQuantity());

        return bookREST;
    }
}
