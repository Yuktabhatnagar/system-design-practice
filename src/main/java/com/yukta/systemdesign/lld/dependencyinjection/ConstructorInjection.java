package com.yukta.systemdesign.lld.dependencyinjection;
//Main → creates MySQLRepository → injects into UserService
interface UserRepository2 {
    void saveUser();
}

class MySQLRepository implements UserRepository2 {
    public void saveUser() {
        System.out.println("Saving user in MySQL");
    }
}

class MongoRepository implements UserRepository2 {
    public void saveUser() {
        System.out.println("Saving user in MongoDB");
    }
}

// Inject Dependency (Constructor Injection 🔥)
class UserService2 {

    private UserRepository2 repo;

    public UserService2(UserRepository2 repo) { // injected
        this.repo = repo;
    }
////    Setter Injection
//    public void setRepo(UserRepository repo) {
//        this.repo = repo;
//    }
    public void save() {
        repo.saveUser();
    }
}

public class ConstructorInjection {
    public static void main(String[] args) {
//        UserRepository2 repo = new MySQLRepository(); // choose implementation
//        UserService2 service = new UserService2(repo);
// This line is DI: new UserService(repo);
        UserService2 service = new UserService2(new MySQLRepository());
        service.save();
    }
}