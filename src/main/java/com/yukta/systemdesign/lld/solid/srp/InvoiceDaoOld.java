package com.yukta.systemdesign.lld.solid.srp;
//4
public class InvoiceDaoOld {
   InvoiceUpdated invoice;
    //Data Access Layer
    public InvoiceDaoOld(InvoiceUpdated invoice) {
        this.invoice = invoice;
    }

    public void saveToDB(){
        //Save the invoice to db
    }

    public void saveToFile(String filename){
        //Save the invoice in the file with the given name
    }
}




