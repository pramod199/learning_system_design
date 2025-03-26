package lld.chain_of_responsibility_design_pattern.authentication_app;

public class AuthenticationService {
    private Handler handler;

    public AuthenticationService(Handler handler) {
        this.handler = handler;
    }

    public boolean login(String username, String password) {
        if (handler.handle(username, password)) {
            System.out.println("Authorization successful!");
            return true;
        }
        return false;
    }
}
