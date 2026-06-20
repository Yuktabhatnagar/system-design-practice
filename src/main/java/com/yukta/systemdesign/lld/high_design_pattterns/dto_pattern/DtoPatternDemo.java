package com.yukta.systemdesign.lld.high_design_pattterns.dto_pattern;

public class DtoPatternDemo {

    public static void main(String[] args) {
        CustomerEntity entity = new CustomerEntity(1, "Yukta", "yukta@example.com", "hashed-password");
        CustomerResponse response = CustomerMapper.toResponse(entity);

        System.out.println(response);
    }
}

record CustomerEntity(int id, String name, String email, String passwordHash) {
}

record CustomerResponse(int id, String name, String email) {
}

class CustomerMapper {

    static CustomerResponse toResponse(CustomerEntity entity) {
        return new CustomerResponse(entity.id(), entity.name(), entity.email());
    }
}
