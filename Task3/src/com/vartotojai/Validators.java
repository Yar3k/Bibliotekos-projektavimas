package com.vartotojai;
/**
 * This bridges imported library (to easier switch for different library)
 * */
import com.lib.*;
public class Validators {
    private EmailValidator emailValidator = new EmailValidator();
    private PasswordChecker passwordChecker = new PasswordChecker();
    private PhoneValidator phoneValidator = new PhoneValidator();
    public boolean ValidateEmail (String email){
        return emailValidator.checkIfExists(email) &&
                emailValidator.checkAtSign(email) &&
                !emailValidator.checkIllegalSymbols(email) &&
                emailValidator.checkDomain(email);
    }

    public boolean ValidatePassword (String password){
        return passwordChecker.checkIfExists(password) &&
                passwordChecker.checkLenght(password) &&
                passwordChecker.checkUpperCase(password) &&
                passwordChecker.checkSpecialSymbol(password);
    }

    public boolean ValidatePhone (String phone, String countryCode){
        return phoneValidator.checkIfExists(phone) &&
                phoneValidator.checkForOtherSymbols(phone) &&
                phoneValidator.checkForValidCountryNumber(phone, countryCode);
    }

    public String NumberFormatChanger(String number){
        if (phoneValidator.changeNumberFormer(number).equals("+370") && number.startsWith("8")) return "+370"+ number.substring(1,number.length());
        return number;
    }
}
