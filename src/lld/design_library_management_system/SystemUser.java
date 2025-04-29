package lld.design_library_management_system;

import lld.design_library_management_system.enums.AccountStatus;

public class SystemUser extends Person {
     String username;
     String password;
     int userId;
     AccountStatus accountStatus;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }
}
