package Sess03;

import java.util.*;
import java.util.stream.Collectors;

record User(String username, String email, String status) {
}

public class Bai04 {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("alice", "alice@gmail.com", "ACTIVE"),
                new User("bob", "bob@yahoo.com", "INACTIVE"),
                new User("alice", "alice2@gmail.com", "ACTIVE"),
                new User("charlie", "charlie@gmail.com", "ACTIVE"));

        List<User> uniqueUsers = new ArrayList<>(
                users.stream()
                        .collect(Collectors.toMap(
                                User::username,
                                u -> u,
                                (u1, u2) -> u1))
                        .values());
        uniqueUsers.forEach(System.out::println);
    }
}