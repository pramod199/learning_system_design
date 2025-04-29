package lld.design_zomato;

public abstract class IPartner {
    protected String name;
    protected Rating rating; // Assuming you have an enum called Rating

    public IPartner(String name) {
        this.name = name;
        this.rating = Rating.UNASSIGNED;
    }

    public String getName() {
        return name;
    }

    // Optionally abstract method for subclasses
    // public abstract void performKyc();
}
