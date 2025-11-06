package lld.design_inventory_and_order_management;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {
    Map<Integer, User> users;
    public UserController() {
        this.users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public User getUser(int userId) {
        return users.get(userId);
    }


}
