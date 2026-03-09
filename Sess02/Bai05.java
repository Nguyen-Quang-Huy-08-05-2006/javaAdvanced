interface UserActions {

    default void logActivity(String activity) {
        System.out.println("User action: " + activity);
    }
}

interface AdminActions {

    default void logActivity(String activity) {
        System.out.println("Admin action: " + activity);
    }
}

class SuperAdmin implements UserActions, AdminActions {

    @Override
    public void logActivity(String activity) {

        UserActions.super.logActivity(activity);
        AdminActions.super.logActivity(activity);
    }
}

public class Bai05 {

    public static void main(String[] args) {

        SuperAdmin superadmin = new SuperAdmin();

        superadmin.logActivity("He thong duoc truy cap");
    }
}