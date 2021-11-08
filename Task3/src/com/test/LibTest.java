package com.test;

import com.lib.EmailValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.vartotojai.*;

import static org.junit.jupiter.api.Assertions.*;

public class LibTest {
    Veiksmai veiksmai;

    @BeforeEach
    void setUp()
    {
        veiksmai = new Veiksmai();
    }
    @Test
    void SingleTestModule(){
        int additional_index=4;//Change it acording saved file
        veiksmai.Prideti("test","test","+37067123123","LT","test@test.lt","test","Testas123@");
        Vartotojas testvar = veiksmai.Istraukti(additional_index);
        assertEquals(testvar.getUserID(), additional_index);
        assertEquals(testvar.getVardas(), "test");
        assertEquals(testvar.getPavarde(), "test");
        assertEquals(testvar.getNumeris(), "+37067123123");
        assertEquals(testvar.getEmail(), "test@test.lt");
        assertEquals(testvar.getAdresas(), "test");
        assertEquals(testvar.getSlaptazodis(), "Testas123@");
        veiksmai.Redakuoti(additional_index,"test2","test2","+37067123333","LT","test2@test.lt","test2","Testas222@");
        testvar = veiksmai.Istraukti(additional_index);
        assertEquals(testvar.getUserID(), additional_index);
        assertEquals(testvar.getVardas(), "test2");
        assertEquals(testvar.getPavarde(), "test2");
        assertEquals(testvar.getNumeris(), "+37067123333");
        assertEquals(testvar.getEmail(), "test2@test.lt");
        assertEquals(testvar.getAdresas(), "test2");
        assertEquals(testvar.getSlaptazodis(), "Testas222@");
        veiksmai.Istrinti(additional_index);
    }
    @Test
    void TestBadPhone(){
        int err = veiksmai.Prideti("test","test","+38067123123","LT","test@test.lt","test","Testas123@");
        assertEquals(err, 1);
    }
    @Test
    void TestBadEmail(){
        int err = veiksmai.Prideti("test","test","+37067123123","LT","testtest.lt","test","Testas123@");
        assertEquals(err, 2);
    }
    @Test
    void TestBadPassword(){
        int err = veiksmai.Prideti("test","test","+37067123123","LT","test@test.lt","test","testas123");
        assertEquals(err, 3);
    }
}
