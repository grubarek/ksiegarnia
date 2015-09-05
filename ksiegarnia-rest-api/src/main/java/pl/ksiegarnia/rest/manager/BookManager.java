package pl.ksiegarnia.rest.manager;

import pl.ksiegarnia.dao.BookDao;
import pl.ksiegarnia.dao.ItemDao;
import pl.ksiegarnia.jpa.Book;
import pl.ksiegarnia.rest.mappers.BookMapper;
import pl.ksiegarnia.rest.mappers.ItemMapper;
import pl.ksiegarnia.rest.model.Item;

import javax.ejb.EJB;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by pgrubarek on 17.08.15.
 */
public class BookManager implements iBook {
    private static final Logger logger = Logger.getLogger(BookManager.class.toString());

    @EJB
    private BookDao bookDao;
    @Override
    public pl.ksiegarnia.rest.model.Book create(pl.ksiegarnia.rest.model.Book book) {
        pl.ksiegarnia.jpa.Book bookJPA = null;
        logger.info("ItemManager.create - invoked");
        try {
            book = BookMapper.mapBookJPAToBookREST(bookJPA);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }
    @Override
    public pl.ksiegarnia.rest.model.Book edit(pl.ksiegarnia.rest.model.Book book) {
        pl.ksiegarnia.jpa.Book bookJPA = null;
        logger.info("BookManager.edit - invoked");
        return null;
    }

    @Override
    public pl.ksiegarnia.rest.model.Book getBook(Long id){
        logger.info("BookManager.getBook - invoked");
        pl.ksiegarnia.rest.model.Book bookREST = null;
        Book bookJPA = null;

        return bookREST;
    }

    // zwraca liste ksiazek, zamiast w rescie dalem do managera
    @Override
    public List<pl.ksiegarnia.rest.model.Book> getBookList (){
        logger.info("BookManager.getBookList - invoked");
        pl.ksiegarnia.rest.model.Book bookREST = null;
        List<pl.ksiegarnia.rest.model.Book> bookList = null;

        for(pl.ksiegarnia.rest.model.Book book : bookList){
            //wywolanie mappera albo metody z managera
            try()
        }
        return bookList;
    }
}
