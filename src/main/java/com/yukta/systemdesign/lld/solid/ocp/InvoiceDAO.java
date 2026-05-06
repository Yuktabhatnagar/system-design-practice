package com.yukta.systemdesign.lld.solid.ocp;

import com.yukta.systemdesign.lld.solid.srp.InvoiceUpdated;

//6
public interface InvoiceDAO {
    public void save(InvoiceUpdated invoice);
}
