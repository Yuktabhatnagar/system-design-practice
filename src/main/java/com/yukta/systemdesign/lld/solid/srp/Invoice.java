package com.yukta.systemdesign.lld.solid.srp;

//2
public class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal(){
        return ((marker.price)* this.quantity);
    }

    public void printInvoice(){
        //Print the invoice
    }

    public void saveToDB(){
       //Save the data into db
    }

}
