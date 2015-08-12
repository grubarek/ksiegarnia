package pl.ksiegarnia.facade;

import pl.ksiegarnia.dao.BookDao;
import pl.ksiegarnia.dao.exception.DaoException;
import pl.ksiegarnia.jpa.Book;

import javax.ejb.Stateless;
import java.util.logging.Logger;


@Stateless
public class BookFacade extends AbstractFacade implements BookDao {
    private static final Logger logger = Logger.getLogger(BookFacade.class.toString());

    public long createBook(Book book) throws DaoException {
        logger.info("BookFacade.createBook");
        try {
            entityManager.persist(book);
            return book.getId();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public boolean updateBook(Book book) throws DaoException {
        logger.info("BookFacade.updateBook - invoked");
        try {
            entityManager.merge(book);
            return true;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }


    public Book getBookById(long bookId) throws DaoException {
        logger.info("BookFacade.getBook - invoked");
        try {
            Book book = entityManager.find(Book.class, bookId);
            return book;
        } catch (Exception e) {
            throw new DaoException(e);
        }

    }

    public boolean deleteBook(long bookId) throws DaoException {
        logger.info("ItemFacade.deleteItem - invoked");
        try {
            Book book = entityManager.find(Book.class, bookId);
            entityManager.remove(book);
            return true;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}

