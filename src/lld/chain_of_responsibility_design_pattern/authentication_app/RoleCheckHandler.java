package lld.chain_of_responsibility_design_pattern.authentication_app;

public class RoleCheckHandler extends Handler {
    @Override
    public boolean handle(String username, String password) {
        if ("admin".equals(username)) {
            System.out.println("Hello admin!");
            return true;
        }
        System.out.println("loading default page...");
        return handleNext(username, password);
    }
}
