package b2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserService UserServiceTest = new UserService();

    @Test
    @DisplayName("18")
    void checkRegistrationAge_01() {
        assertEquals(true, UserServiceTest.checkRegistrationAge(18));
    }

    @Test
    @DisplayName("17")
    void checkRegistrationAge_02() {
        assertEquals(false, UserServiceTest.checkRegistrationAge(17));
    }

    @Test
    @DisplayName("-1")
    void checkRegistrationAge_03() {
        assertThrows(IllegalArgumentException.class, () -> {
            UserServiceTest.checkRegistrationAge(-1);
        });
    }
}