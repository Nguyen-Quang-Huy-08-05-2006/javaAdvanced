@FunctionalInterface
interface Authenticatable {

    String getPassword();

    default boolean isAuthenticated() {
        return getPassword() != null && !getPassword().isEmpty();
    }

    static String encrypt(String rawPassword) {
        return "ENC_" + rawPassword;
    }
}

class Account implements Authenticatable {

    private String password;

    Account(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }
}

public class Bai03 {

    public static void main(String[] args) {

        Account acc = new Account("123456");

        System.out.println(acc.isAuthenticated());

        String encrypted = Authenticatable.encrypt("123456");

        System.out.println(encrypted);
    }
}