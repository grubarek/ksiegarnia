package pl.ksiegarnia.dao;

import pl.ksiegarnia.dao.exception.DaoException;
import pl.ksiegarnia.jpa.Book;
import pl.ksiegarnia.jpa.Item;
import pl.ksiegarnia.jpa.ItemOrder;

import javax.ejb.Remote;
import java.util.List;


@Remote
public interface BookDao {
    long createBook(Book book) throws DaoException;

    boolean updateBook(Book book) throws DaoException;

    Book getBookById(long bookId) throws DaoException;

    boolean deleteBook(long bookId) throws DaoException;

    List<Book> list(int offset, int limit) throws DaoException;

    boolean assignItem(long userId, Item item) throws DaoException;

    boolean assignItemOrder(long userId, ItemOrder itemOrder) throws  DaoException;

    boolean assignBookToUser(long userId,Book book) throws DaoException;
}
