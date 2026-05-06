package com.yukta.systemdesign.lld.solid.srp;

//3
public class InvoiceUpdated {
    private Marker marker;
    private int quantity;

    public InvoiceUpdated(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal(){
        return ((marker.price)* this.quantity);
    }
}
