package com.lib;

public class PasswordChecker {

    private String specialSymbols = "!@#$%^&*()+-";

    public boolean checkIfExists(String password) {
        return password != null && password != "";
    }

    public boolean checkLenght(String password) {
        return password != null && password.length() >= 6;
    }

    public boolean checkUpperCase(String password) {
        return password != null && password.toLowerCase() != password;
    }

    public boolean checkSpecialSymbol(String password) {
        if(password == null) return false;

        for (char symbol : specialSymbols.toCharArray()) {
            if(password.indexOf(symbol) != -1) return true;
        }

        return false;
    }
}
