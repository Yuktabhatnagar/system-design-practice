package com.yukta.systemdesign.lld.solid.ocp;

import com.yukta.systemdesign.lld.solid.srp.InvoiceUpdated;

//7
public class DatabaseInvoiceDao implements InvoiceDAO {
    @Override
    public void save(InvoiceUpdated invoice) {
        //save to DB
    }
}
