package com.yukta.systemdesign.lld.solid.lsp;

import com.yukta.systemdesign.lld.solid.ocp.InvoiceService;

class Notification {

    public static void main(String[] args) {
        Notification notification = new WhatsAppNotification();
        notification.sendNotification();
    }

    public  void sendNotification(){
        System.out.println("Email send");
    }
//    public  void sendAttachment(){
//        System.out.println("Attachment send");
//    }
}

class TextNotification extends Notification{
    @Override
    public void sendNotification(){
        System.out.println("Text send");
    }
}

class WhatsAppNotification extends Notification{
    @Override
    public void sendNotification(){
        System.out.println("Whatsapp Text send");
    }
}



