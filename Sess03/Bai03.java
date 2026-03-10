package Sess03;

import java.util.*;

record User(String username, String email, String status) {
}

class UserRepository {

    List<User> users = Arrays.asList(
            new User("alice", "alice@gmail.com", "ACTIVE"),
            new User("bob", "bob@yahoo.com", "INACTIVE"),
            new User("charlie", "charlie@gmail.com", "ACTIVE"));

    public Optional<User> findUserByUsername(String username) {
        return users.stream()
                .filter(u -> u.username().equals(username))
                .findFirst();
    }
}

public class Bai03 {

    public static void main(String[] args) {

        UserRepository repo = new UserRepository();
        Optional<User> result = repo.findUserByUsername("alice");
        result.ifPresent(u -> System.out.println("Welcome " + u.username()));
        System.out.println(result.map(u -> "").orElse("Guest login"));
    }
}