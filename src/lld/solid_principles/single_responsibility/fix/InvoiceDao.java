package lld.solid_principles.single_responsibility.fix;

public class InvoiceDao { // Data access layer
    Invoice invoice;
    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDb() {
        // Save to database
    }
}
