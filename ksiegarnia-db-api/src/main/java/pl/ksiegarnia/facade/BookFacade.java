package pl.ksiegarnia.facade;

import pl.ksiegarnia.dao.BookDao;
import pl.ksiegarnia.dao.exception.DaoException;
import pl.ksiegarnia.jpa.Book;
import pl.ksiegarnia.jpa.Item;
import pl.ksiegarnia.jpa.ItemOrder;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;
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
        logger.info("BookFacade.deleteItem - invoked");
        try {
            Book book = entityManager.find(Book.class, bookId);
            entityManager.remove(book);
            return true;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public List<Book> list(int offset, int limit)  throws DaoException{
        logger.info("BookFacade.list - invoked");
        try{
            TypedQuery<Book> query = entityManager.createQuery("SELECT x FROM Book x ", Book.class);
            query.setFirstResult(offset).setMaxResults(limit);
            return query.getResultList();
        }catch (Exception e) {
            throw new DaoException(e);
        }
    }
//TODO napisac metody przydzielajace ksiazke i zamowienie i "item' do id uzytkownika
    @Override
    public boolean assignItem(long userId, Item item) throws DaoException {
        return false;
    }

    @Override
    public boolean assignItemOrder(long userId, ItemOrder itemOrder) throws DaoException {
        return false;
    }

    @Override
    public boolean assignBookToUser(long userId, Book book) throws DaoException {
        return false;
    }


}

