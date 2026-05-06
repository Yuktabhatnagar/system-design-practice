package com.yukta.systemdesign.lld.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


interface UserRepository4 {
    void saveUser();
}

@Repository
@Profile("mysql")
class MySQLRepository4 implements UserRepository4 {
    @Override
    public void saveUser() {
        System.out.println("Saving user in MySQL");
    }
}

@Repository
@Profile("mongo")
class MongoRepository4 implements UserRepository4 {
    @Override
    public void saveUser() {
        System.out.println("Saving user in MongoDB");
    }
}

// Inject Dependency (Field Injection 🔥)
@Service
class UserService4 {
    @Autowired
    private UserRepository4 repo;  // injected directly into field

    public void save() {
        repo.saveUser();
    }
}

@Configuration
@ComponentScan(basePackageClasses = FieldInjection.class)
class FieldInjectionConfig {
}

public class FieldInjection {
    public static void main(String[] args) {
        //Profiles usage, -> No @Qualifier needed
        System.setProperty("spring.profiles.active", "mongo");
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(FieldInjectionConfig.class)) {
            UserService4 service = context.getBean(UserService4.class);
            service.save();
        }
    }
}
