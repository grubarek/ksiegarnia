package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by pgrubarek on 11.08.15.
 *
 * Bean sesyjny.
 *
 * Przechowuje informacje o zalogowanym użytkowniku.
 *
 */
@ManagedBean
@SessionScoped
public class SessionBean  implements Serializable{

    private static final long serialVersionUID = 1269006456853097810L;

    private static Logger logger = Logger.getLogger(SessionBean.class.toString());

    private Map<Key, Object> map;

    public SessionBean() {

    }
    public enum Key {
        LOGGEDIN_USERNAME,
        LOGGEDIN_USER_ID,
        LOGGEDIN_USERROLE,
        SELECTED_USER, //użytkownik/konto zaznaczony
        SELECTED_APPLICATION_DATA_ENTRY, //dane aplikacji
        SELECTED_APPLICATION_VERSION,
        SELECTED_ITEM,
        SELECTED_BOOK,
        SELECTED_ORDER,
        MODE //tryb: EDIT lub VIEW lub NEW
    }
}
