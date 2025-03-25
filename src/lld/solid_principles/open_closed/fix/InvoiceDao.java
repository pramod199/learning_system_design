package lld.solid_principles.open_closed.fix;

import lld.solid_principles.single_responsibility.fix.Invoice;

public interface InvoiceDao {
    void save(Invoice invoice);

}
