package lld.chain_of_responsibility_design_pattern.authentication_app;

public class ValidPasswordHandle extends Handler {
    private Database database;

    public ValidPasswordHandle(Database database) {
        this.database = database;
    }

    @Override
    public boolean handle(String username, String password) {
        if (!database.isValidPassword(username, password)) {
            System.out.println("Wrong Password!");
            return false;
        }
        return handleNext(username, password);
    }
}
