package pl.ksiegarnia.dao;

import pl.ksiegarnia.dao.exception.DaoException;
import pl.ksiegarnia.jpa.Book;

import javax.ejb.Remote;



@Remote
public interface BookDao {
    long createBook(Book book) throws DaoException;

    boolean updateBook(Book book) throws DaoException;

    Book getBookById(long bookId) throws DaoException;

    boolean deleteBook(long bookId) throws DaoException;
}
