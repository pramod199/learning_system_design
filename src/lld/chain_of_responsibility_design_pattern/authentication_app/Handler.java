package lld.chain_of_responsibility_design_pattern.authentication_app;

public abstract class Handler {

    private Handler next;

//    public Handler(Handler next) {
//        this.next = next;
//    }

    // in place of constructor can have this setter method
    public Handler setNextHandle(Handler next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(String username, String password);

    protected boolean handleNext(String username, String password) {
        if (next == null) {
            return true;
        }
        return next.handle(username, password);
    }
}
