package configuration;

import java.util.List;

/**
 * Created by pgrubarek on 11.08.15.
 */
public class Privileges {

    /*
    * private static final long serialVersionUID = 1269325432781097810L;
	private static Map<Action, List<String>> privileges = new HashMap<>();
	static {
		privileges.put(Action.EDIT_USER, Arrays.asList("ADMIN"));
		privileges.put(Action.EDIT_OWN_DATA, Arrays.asList("ADMIN", "AGENT PREMIUM"));
		privileges.put(Action.VIEW_USER_LIST, Arrays.asList("ADMIN"));
		privileges.put(Action.EDIT_APPLICATION_DATA, Arrays.asList("ADMIN"));
		privileges.put(Action.EDIT_QUESTIONS, Arrays.asList("ADMIN"));
		privileges.put(Action.VIEW_ALL_MEETINGS, Arrays.asList("ADMIN"));
	}


	 * Zwraca true jeśli określona rola ma prawo do wykonania danej akcji.
	 * @param action - akcja
	 * @param role - nazwa roli
	 * @return - true jeśli rola posiada uprawnienia dla danej akcji

    public static boolean hasPrivilege(Action action, String role) {
        List<String> roles = privileges.get(action);
        for (String r : roles) {
            if (r.equalsIgnoreCase(role)) {
                return true;
            }
        }
        return false;
    }

    public enum Action {
        EDIT_USER,
        EDIT_OWN_DATA,
        VIEW_USER_LIST,
        EDIT_APPLICATION_DATA,
        EDIT_QUESTIONS ,
        VIEW_ALL_MEETINGS
    }
    */
}
