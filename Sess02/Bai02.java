import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;

class User {
    String username;
    String role;

    User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    String getUsername() {
        return username;
    }

    String getRole() {
        return role;
    }

    public String toString() {
        return "User: " + username + " - Role: " + role;
    }
}

public class Bai02 {

    public static void main(String[] args) {

        User u1 = new User("bop", "ADMIN");
        Predicate<User> isAdmin = user -> user.getRole().equals("ADMIN");
        Function<User, String> getUsername = user -> user.getUsername();
        Consumer<User> printUser = user -> System.out.println(user);
        Supplier<User> createUser = () -> new User("guest", "USER");

        System.out.println(isAdmin.test(u1));
        System.out.println(getUsername.apply(u1));
        printUser.accept(u1);

        User newUser = createUser.get();
        printUser.accept(newUser);
    }
}