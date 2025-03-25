package lld.solid_principles.open_closed;

import lld.solid_principles.single_responsibility.fix.Invoice;

public class InvoiceDao { // Data access layer
    Invoice invoice;
    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDb() {
        // Save to database
    }

    /*
    In future if come requirement for save to file and if we add saveToFile method then we are changing the existing code.
    it breaks open closed principle.
     */
    public void saveToFile() {
        // Save to file
    }
}
