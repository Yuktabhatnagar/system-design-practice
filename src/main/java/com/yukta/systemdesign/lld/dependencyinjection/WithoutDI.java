package com.yukta.systemdesign.lld.dependencyinjection;
// UserService → new UserRepository → new MySQLRepository
class UserRepository1 {
    public void save(){
        //Creates dependency
        MySQLRepository1 mySQLRepository1= new MySQLRepository1();
        mySQLRepository1.saveUser();
    }
}

class MySQLRepository1 {
    public void saveUser() {
        System.out.println("Saving user in MySQL");
    }
}

// Without DI (Bad Design)
class UserService {
    private UserRepository1 repo = new UserRepository1(); // tightly coupled
    public void save() {
        repo.save();
    }
}

public class WithoutDI {
    public static void main(String[] args) {
        UserService service = new UserService();
        service.save();
    }
}