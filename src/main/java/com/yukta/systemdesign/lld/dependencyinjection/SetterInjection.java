package com.yukta.systemdesign.lld.dependencyinjection;

interface UserRepository3 {
    void saveUser();
}

class MySQLRepository2 implements UserRepository3 {
    public void saveUser() {
        System.out.println("Saving user in MySQL");
    }
}

class MongoRepository2 implements UserRepository3 {
    public void saveUser() {
        System.out.println("Saving user in MongoDB");
    }
}

// Inject Dependency (Constructor Injection 🔥)
class UserService3 {

    private UserRepository3 repo;

//    Setter Injection
    public void setRepo(UserRepository3 repo) {
        this.repo = repo;
    }
    public void save() {
        repo.saveUser();
    }
}

public class SetterInjection {
    public static void main(String[] args) {
        UserRepository3 repo = new MySQLRepository2(); // choose implementation
        UserService3 service= new UserService3();
        service.setRepo(repo);
        service.save();
    }
}