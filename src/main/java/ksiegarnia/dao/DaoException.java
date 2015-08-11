package ksiegarnia.dao;

/**
 * Created by michal on 30/03/15.
 */
public class DaoException extends Exception {
    private static final long serialVersionUID = -2507323887109046425L;

    public DaoException() {
        super();
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
