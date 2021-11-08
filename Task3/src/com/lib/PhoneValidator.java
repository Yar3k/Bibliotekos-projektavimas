package com.lib;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class PhoneValidator {

    public boolean checkIfExists(String number) {
        return number != null && number != "";
    }

    public boolean checkForOtherSymbols(String number) {
        if(number == null) return false;

        if(number.startsWith("+")) number = number.substring(1);

        for(char numberChar : number.toCharArray()) {
            if("1234567890".indexOf(numberChar) == -1) return false;
        }

        return true;
    }

    public String changeNumberFormer(String number) {
        if(number != null && (number.startsWith("86") || number.startsWith("+370"))) return "+370";

        return number;
    }

    public boolean checkForValidCountryNumber(String number, String countryCode) {
        if(number == null || countryCode == null) return false;

        JSONParser parser = new JSONParser();
        JSONObject numberCodes = null;
        try {
            numberCodes = (JSONObject) parser.parse(new FileReader("src/com/lib/files/phones.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        if(numberCodes.get(countryCode) == null) return false;

        return number.startsWith("+" + numberCodes.get(countryCode));
    }
}
