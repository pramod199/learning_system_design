package lld.solid_principles.open_closed.fix;

import lld.solid_principles.single_responsibility.fix.Invoice;

/*
 If later comes requirement for saveTOMongodb then we don't need to change this file, instead we will create new class implementing InvoiceDao
 */
public class DatabaseInvoiceDao implements InvoiceDao {
    @Override
    public void save(Invoice invoice) {
        // Save to database mySql

    }
}
