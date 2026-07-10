package com.yukta.systemdesign.lld.designpatterns.creational.singleton;

    public class BillPughSingleton {
        // Private constructor
        private BillPughSingleton() {}

        // Static inner class to hold the Singleton instance
        private static class Holder {
            private static final BillPughSingleton INSTANCE = new BillPughSingleton();
        }

        // Public method to return the Singleton instance
        public static BillPughSingleton getInstance() {
            return Holder.INSTANCE;
        }

}
