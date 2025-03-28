package lld.design_splitwise.user;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    // add User
    public void addUser(User user) {
        users.add(user);
    }


    public User getUser(String userId) {
        for (User user : users) {
            if (user.userId.equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return users;
    }
}
