package lld.chain_of_responsibility_design_pattern.authentication_app;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Handler handler1 = new UserExistHandler(database);
        Handler handler2 = new ValidPasswordHandle(database);
        Handler handler3 = new RoleCheckHandler();

        handler1.setNextHandle(handler2);
        handler2.setNextHandle(handler3);

        // another way to chain. don't reset the handler
        Handler handler = new UserExistHandler(database);

        handler.setNextHandle(new ValidPasswordHandle(database))
                .setNextHandle(new RoleCheckHandler());
        AuthenticationService authenticationService = new AuthenticationService(handler1);
        authenticationService.login("user1", "password1");

    }
}
