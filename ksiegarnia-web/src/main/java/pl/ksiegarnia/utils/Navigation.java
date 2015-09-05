package pl.ksiegarnia.utils;

/**
 * Created by pgrubarek on 11.08.15.
 */
public class Navigation {
    public static final String HOMEPAGE = User.VIEW;
    public static final String LOGIN = "/index.xhtml?faces-redirect=true";
    public static final String MY_ACCOUNT = "/pages/user.xhtml?faces-redirect=true";

    public static final class Mode {
        public static final String RENT = "RENT"; //edycja rekordu
        public static final String VIEW = "VIEW"; //podgląd rekordu
        public static final String ADD = "ADD";
        public static final String NEW_ITEM = "NEW_ITEM";   //dodawanie nowego rekordu
    }

    public static final class User {
        public static final String SECTION_PATH = "/pages/user/";
        public static final String ADD_USER = SECTION_PATH+  "addUser.xhtml?faces-redirect=true";
        public static final String ADD_COMMENT = SECTION_PATH + "addComment.xhtml?faces-redirect=true";
        public static final String DETAILS = SECTION_PATH + "show.xhtml?faces-redirect=true";
        public static final String VIEW = SECTION_PATH + "userView.xhtml?faces-redirect=true";
    }

    public static final class Book {
        public static final String SECTION_PATH = "/pages/book/";
        public static final String LIST = SECTION_PATH + "";
        public static final String ADD_COMMENT = SECTION_PATH + "addComment.xhtml?faces-redirect=true";
        public static final String DETAILS = SECTION_PATH + "show.xhtml?faces-redirect=true";
        public static final String VIEW = SECTION_PATH + "bookView.xhtml?faces-redirect=true";
        public static final String ADD_BOOK = SECTION_PATH + "addBook.xhtml?faces-redirect=true";
    }
}
