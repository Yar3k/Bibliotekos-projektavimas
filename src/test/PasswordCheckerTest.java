package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PasswordCheckerTest {

    PasswordChecker passwordChecker;
    @BeforeEach
    void setUp() {
        passwordChecker = new PasswordChecker();
    }

    @Test
    void checkCheckerLength_True (){
        assertTrue(passwordChecker.isPasswordValid("Password@", 7, "+-!@#"));
    }

    @Test
    void checkCheckerLength_False (){
        assertFalse(passwordChecker.isPasswordValid("Password@", 15, "+-!@#"));
    }

    @Test
    void checkCheckerSymbol_False (){
        assertFalse(passwordChecker.isPasswordValid("Password", 7, "+-!@#"));
    }

    @Test
    void checkCheckerUppercase_False (){
        assertFalse(passwordChecker.isPasswordValid("password@", 7, "+-!@#"));
    }

    @Test
    void checkCheckerSymbolNull_False (){
        assertFalse(passwordChecker.isPasswordValid("Password@", 7, null));
    }

    @Test
    void checkCheckerSymbolEmpty_False (){
        assertFalse(passwordChecker.isPasswordValid("Password@", 7, ""));
    }

    @Test
    void checkCheckerPasswordNull_False (){
        assertFalse(passwordChecker.isPasswordValid(null, 7, "+-!@#"));
    }

    @Test
    void checkCheckerZeroLength_False (){
        assertFalse(passwordChecker.isPasswordValid("Password@", 0, "+-!@#"));
    }

    @Test
    void checkCheckerNegativeLength_False (){
        assertFalse(passwordChecker.isPasswordValid("Password@", -5, "+-!@#"));
    }

    @AfterEach
    void tearDown() {

    }
}
