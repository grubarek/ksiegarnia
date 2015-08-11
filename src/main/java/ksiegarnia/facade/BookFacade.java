package ksiegarnia.facade;

import ksiegarnia.dao.BookDao;
import ksiegarnia.dao.DaoException;
import ksiegarnia.model.Book;

import javax.persistence.TypedQuery;
import java.util.List;

public class BookFacade extends AbstractFacade implements BookDao {


    public long createBook(Book book) throws DaoException {
        logger.info("createBook - invokerd" + book.getId());
        try{
            em.persist(book);
            return book.getId();
        }catch (Exception e){
            throw new DaoException(e);
        }
    };

    public boolean deleteBook(long bookId) throws DaoException{
        logger.info("delete book - invoked for: " + bookId);
        try{
            Book book = em.find(Book.class, bookId);
            em.remove(book);
            return true;
        }catch (Exception e){
            throw new DaoException(e);
        }
    };


    public boolean updateBook(Book book) throws  DaoException{
        logger.info("update invoked for: " + book.getId());
        try{
            em.merge(book);
            return true;
        }catch (Exception e){
            throw new DaoException(e);
        }
    };


    public List<Book> getListOfBooks(int offset, int limit) throws DaoException{
        logger.info("BookFacade.getListOfBooks - invoked");
        try{
            TypedQuery<Book> query = em.createQuery("SELECT x FROM Book x ORDER BY x.id", Book.class);
            query.setFirstResult(offset).setMaxResults(limit);
            return query.getResultList();
        }catch (Exception e) {
            throw new DaoException(e);
        }
    };


    public Book getBookById(long bookId) throws DaoException{
        logger.info("BookFacade.getBookById - invoked");
        try{
            Book book = em.find(Book.class, bookId);
            book.getId();
            return  book;
        }catch (Exception e){
            throw new DaoException(e);
        }
    };



}
