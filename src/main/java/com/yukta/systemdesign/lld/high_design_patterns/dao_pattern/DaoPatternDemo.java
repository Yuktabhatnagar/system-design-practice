package com.yukta.systemdesign.lld.high_design_patterns.dao_pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DaoPatternDemo {

    public static void main(String[] args) {
        UserDao userDao = new InMemoryUserDao();

        userDao.save(new User(1, "Yukta"));

        userDao.findById(1)
                .map(User::name)
                .ifPresent(System.out::println);
    }
}

record User(int id, String name) {
}

interface UserDao {
    void save(User user);

    Optional<User> findById(int id);
}

class InMemoryUserDao implements UserDao {

    private final Map<Integer, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.id(), user);
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.ofNullable(users.get(id));
    }
}
