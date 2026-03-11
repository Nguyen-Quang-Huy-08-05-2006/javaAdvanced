package b1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    UserValidator userValidator = new UserValidator();

    @DisplayName("TC01")
    @Test
    void TC01() {
        assertTrue(userValidator.isValidUsername("user123"));
    }

    @DisplayName("TC02")
    @Test
    void TC02() {
        assertFalse(userValidator.isValidUsername("abc"));
    }

    @DisplayName("TC03")
    @Test
    void TC03() {
        assertFalse(userValidator.isValidUsername("user name"));
    }

}