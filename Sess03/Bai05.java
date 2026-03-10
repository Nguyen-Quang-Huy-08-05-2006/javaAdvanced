package Sess03;

import java.util.*;

record User(String username, String email, String status) {
}

public class Bai05 {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("alexander", "alex@gmail.com", "ACTIVE"),
                new User("bob", "bob@gmail.com", "ACTIVE"),
                new User("charlotte", "charlotte@gmail.com", "ACTIVE"),
                new User("tom", "tom@gmail.com", "INACTIVE"),
                new User("benjamin", "ben@gmail.com", "ACTIVE"),
                new User("anna", "anna@gmail.com", "ACTIVE"));
        users.stream()
                .sorted(Comparator.comparingInt((User u) -> u.username().length()).reversed())
                .limit(3)
                .map(User::username)
                .forEach(System.out::println);
    }
}