package b2;

public class UserService {
    public boolean checkRegistrationAge(int age){
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        if(age < 18){
            return false;
        }

        return true;

    }
}
