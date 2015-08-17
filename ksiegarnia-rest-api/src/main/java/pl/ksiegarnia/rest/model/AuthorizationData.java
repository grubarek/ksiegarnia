package pl.ksiegarnia.rest.model;

/**
 * Created by pgrubarek on 17.08.15.
 */
import java.io.Serializable;
import java.util.logging.Logger;

public class AuthorizationData implements Serializable {
    private static final Logger logger = Logger.getLogger("AuthorizationData");
    private  static final long serialVersionUID = -3057132316362733253L;

    private String username;//nazwa użytkownika
    private String password;//haslo użytkownika


    public AuthorizationData() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return  String.format("AuthorizationData{username='%s', password='%s'", username, password);
    }
    public boolean isValid() {

        if (username == null || username.isEmpty()) {
            logger.warning("isValid, username not provided.");
            return false;
        }
        if (password == null || password.isEmpty()) {
            logger.warning("isValid, password not provided.");
            return false;
        }
        return true;
    }
}
