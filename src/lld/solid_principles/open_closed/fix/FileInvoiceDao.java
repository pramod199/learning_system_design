package lld.solid_principles.open_closed.fix;

import lld.solid_principles.single_responsibility.fix.Invoice;

public class FileInvoiceDao implements InvoiceDao {
    @Override
    public void save(Invoice invoice) {
        // Save to file
    }
}
