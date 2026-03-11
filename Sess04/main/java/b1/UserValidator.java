package b1;

public class UserValidator {
    public boolean isValidUsername(String username){
        if(username == null){
            return false;
        }

        int len = username.length();

        if(len >= 6 && len <= 20 && !username.contains(" ")){
            return true;
        }

        return false;
    }
}
