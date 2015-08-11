package ksiegarnia.dao;

import ksiegarnia.model.Book;

import java.util.List;

public interface BookDao {

    public long createBook(Book book) throws DaoException;
    public boolean deleteBook(long bookId) throws DaoException;
    public boolean updateBook(Book book) throws  DaoException;
    public List<Book> getListOfBooks(int offset, int limit) throws DaoException;
    public Book getBookById(long bookId) throws DaoException;

}
