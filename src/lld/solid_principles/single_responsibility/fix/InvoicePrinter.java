package lld.solid_principles.single_responsibility.fix;

public class InvoicePrinter {

    private Invoice invoice;
    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void printInvoice() {
        // print invoice
    }
}
