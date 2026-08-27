package com.yukta.systemdesign.hld.high_design_patterns.fluent_interface;

public class FluentInterfaceDemo {
    public static void main(String[] args) {
        Query query = new Query().select("name, email").from("users").where("active = true");
        System.out.println(query.build());
    }
}

class Query {
    private String select;
    private String from;
    private String where;
    Query select(String select) { this.select = select; return this; }
    Query from(String from) { this.from = from; return this; }
    Query where(String where) { this.where = where; return this; }
    String build() { return "SELECT " + select + " FROM " + from + " WHERE " + where; }
}
