package b4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PasswordUtilsTest {

    // TC01
    @Test
    void testStrongPassword() {
        assertEquals("Mạnh",
                PasswordUtils.evaluatePasswordStrength("Abc123!@"));
    }

    // TC02
    @Test
    void testMissingUppercase() {
        assertEquals("Trung bình",
                PasswordUtils.evaluatePasswordStrength("abc123!@"));
    }

    // TC03
    @Test
    void testMissingLowercase() {
        assertEquals("Trung bình",
                PasswordUtils.evaluatePasswordStrength("ABC123!@"));
    }

    // TC04
    @Test
    void testMissingDigit() {
        assertEquals("Trung bình",
                PasswordUtils.evaluatePasswordStrength("Abcdef!@"));
    }

    // TC05
    @Test
    void testMissingSpecialCharacter() {
        assertEquals("Trung bình",
                PasswordUtils.evaluatePasswordStrength("Abc12345"));
    }

    // TC06
    @Test
    void testPasswordTooShort() {
        assertEquals("Yếu",
                PasswordUtils.evaluatePasswordStrength("Ab1!"));
    }

    // TC07
    @Test
    void testOnlyLowercase() {
        assertEquals("Yếu",
                PasswordUtils.evaluatePasswordStrength("password"));
    }

    // TC08
    @Test
    void testUppercaseAndNumberOnly() {
        assertEquals("Yếu",
                PasswordUtils.evaluatePasswordStrength("ABC12345"));
    }
}