import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class User {
    private String username;

    User() {
        this.username = "defaultUser";
    }

    User(String username) {
        this.username = username;
    }

    String getUsername() {
        return username;
    }

    public String toString() {
        return username;
    }
}

public class Bai04 {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("Alice"),
                new User("Bob"),
                new User("Charlie"));

        users.stream()
                .map(User::getUsername)
                .forEach(System.out::println);

        Supplier<User> createUser = User::new;

        User newUser = createUser.get();

        System.out.println(newUser);
    }
}