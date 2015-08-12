package pl.ksiegarnia.rest.model;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class AbstractRest {
	protected final String LOGIN_KEY = "login_key";
	protected Logger logger = Logger.getLogger(this.toString());
	protected Boolean checkAuthorization(HttpServletRequest request) {

		HttpSession httpSession = request.getSession();

		if (httpSession == null) {
			return false;
		}

		String login = (String) httpSession.getAttribute(LOGIN_KEY);

		if (login == null) {
			return false;
		}

		return true;

	}
	
	protected String getLogin(HttpServletRequest request){
		HttpSession httpSession = request.getSession();

		if (httpSession == null) {
			return null;
		}

		String login = (String) httpSession.getAttribute(LOGIN_KEY);
		return login;
	}
}
