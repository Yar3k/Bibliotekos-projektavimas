package test;

import main.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class EmailValidatorTest {

    EmailValidator emailValidator;
    @BeforeEach
    void setUp() {
        emailValidator = new EmailValidator();
    }

    @Test
    void checkNoAtSign (){
        assertFalse(emailValidator.validate("gmail.com"));
    }

    @Test
    void checkNoNamePart (){
        assertFalse(emailValidator.validate("@gmail.com"));
    }

    @Test
    void checkValidName (){
        assertTrue(emailValidator.validate("abc_def@mail.com"));
    }

    @Test
    void checkAtSign (){
        assertTrue(emailValidator.validate("vardenis@gmail.com"));
    }

    @Test
    void checkInvalidSymbol1 (){
        assertFalse(emailValidator.validate("vardenis pavardenis@gmail.com"));
    }

    @Test
    void checkInvalidSymbol2 (){
        assertFalse(emailValidator.validate("vardenis\"is@gmail.com"));
    }

    @Test
    void checkInvalidDomain1 (){
        assertFalse(emailValidator.validate("vardenis.pavardenis@g#mail.com"));
    }
    @Test
    void checkInvalidDomain2 (){
        assertFalse(emailValidator.validate("vardenis.pavardenis@gmail..com"));
    }

    @Test
    void checkValidDomain (){
        assertTrue(emailValidator.validate("abc.def@mail-archive.com"));
    }

    @Test
    void checkEmpty (){
        assertFalse(emailValidator.validate(""));
    }

    @Test
    void checkNull (){
        assertFalse(emailValidator.validate(null));
    }

    @AfterEach
    void tearDown() {

    }
}
