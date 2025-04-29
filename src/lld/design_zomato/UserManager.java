package lld.design_zomato;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private static UserManager userManagerInstance;
    private Map<String, User> usersMap = new HashMap<>();

    private UserManager() {}

    public static UserManager getUserManager() {
        if (userManagerInstance == null) {
           synchronized (UserManager.class) {
                if (userManagerInstance == null) {
                    userManagerInstance = new UserManager();
                }
            }
        }
        return userManagerInstance;
    }

    public void addUser(String userName, User user) {
        usersMap.put(userName, user);
    }

    public User getUser(String userName) {
        return usersMap.get(userName);
    }
}
