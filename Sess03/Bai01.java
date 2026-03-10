package Sess03;

import java.util.*;

record User(String username, String email, String status) {
}

public class Bai01 {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("alice", "alice@gmail.com", "ACTIVE"),
                new User("bob", "bob@gmail.com", "INACTIVE"),
                new User("charlie", "charlie@gmail.com", "ACTIVE"));

        users.forEach(System.out::println);
    }
}