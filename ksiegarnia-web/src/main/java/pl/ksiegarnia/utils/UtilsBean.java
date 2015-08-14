package pl.ksiegarnia.utils;


import org.apache.commons.codec.digest.DigestUtils;
import pl.ksiegarnia.jpa.User;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by pgrubarek on 13.08.15.
 */
@ManagedBean(eager=true)
@ApplicationScoped
public class UtilsBean implements Serializable {
    private static final long serialVersionUID = 1582641298743595332L;
    public String DATE_FORMAT = "dd.MM.yyyy HH:mm";


    /**
     * Zwraca sformatowaną datę jako string.
     *
     * @param timestamp
     * @return
     */
    public String getDateString(Timestamp timestamp) {
        SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
        if (timestamp != null)
            return df.format(timestamp);
        else
            return "";
    }

    public String getIconByStatus(Integer status) {
        if (status == null) {
            return "";
        }
        if (status == User.STATUS_ACTIVE) {
            return "ui-icon ui-icon-locked";
        } else if (status == User.STATUS_BLOCKED) {
            return "ui-icon ui-icon-unlocked";
        }
        return "";
    }

    public boolean isActive(int status) {
        if (status == User.STATUS_ACTIVE) {
            return true;
        }


        return false;
    }

    public boolean isBlocked(int status) {
        if (status == User.STATUS_BLOCKED) {
            return true;
        }

        return false;
    }

    public static String generateSalt() {
        return DigestUtils.shaHex(new Date().toString() + UUID.randomUUID().toString());
    }

    public static String getPasswordHash(String password, String salt) {
        return DigestUtils.shaHex(salt + password);
    }

    public static String getSha512Hash(String str) {
        return DigestUtils.shaHex(str);
    }

    public static String generateRandomHash(String str) {
        return DigestUtils.shaHex(str + new Date().toString() + UUID.randomUUID().toString());
    }

    public static String generateHash(String str) {
        return DigestUtils.shaHex(str);
    }


    public static String generateRandomPassword() {
        String [] partsUpper = {"GO", "LA", "HY", "MA", "PA", "PE", "CY", "GE", "WY", "SA", "KE", "RU", "ZU", "PU", "KU", "TY", "JA", "TA", "MU"};
        String [] partsLower = {"to", "co", "ry", "pa", "da", "be", "te", "py", "sa", "fe", "cu", "ce", "nu", "ja", "hu", "my", "ta", "ty", "cy"};
        String [] specials = {"@", "#", "$", "%", "!", "^"};
        Random rnd = new Random(new Date().getTime());
        StringBuffer ret = new StringBuffer();
        ret.append(partsUpper[rnd.nextInt(partsUpper.length)]);
        ret.append(partsLower[rnd.nextInt(partsLower.length)]);
        ret.append(specials[rnd.nextInt(specials.length)]);
        ret.append(partsUpper[rnd.nextInt(partsUpper.length)]);
        ret.append(partsLower[rnd.nextInt(partsLower.length)]);
        ret.append(rnd.nextInt(99));
        ret.append(specials[rnd.nextInt(specials.length)]);
        return ret.toString();
    }


}
