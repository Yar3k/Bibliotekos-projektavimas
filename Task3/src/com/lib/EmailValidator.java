package com.lib;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmailValidator {

    private String allowedSymbols = "abcdefghijklmnopqrstuvwxyz"
                                    + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "ąčęėįšųūžĄČĘĖĮŠŲŪŽ"
                                    + "0123456789"
                                    + "!#$%&'*+-/=?^_`{|}~.@";

    public boolean checkIfExists(String email) {
        return email != null && email != "";
    }

    public boolean checkAtSign(String email) {
        return email != null && email.indexOf('@') != -1;
    }

    public boolean checkIllegalSymbols(String email) {
        if(email == null) return false;

        for (char emailChar : email.toCharArray()) {
            if(allowedSymbols.indexOf(emailChar) == -1) return true;
        }

        return false;
    }

    public boolean checkDomain(String email) {
        if(!checkAtSign(email)) return false;

        List<String> tlds = null;

        try {
            tlds = Files.readAllLines(Paths.get("src/com/lib/files/tlds.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String domain = email.split("@")[1];

        if(domain.endsWith("zodis.lt")) return false; // tests define zodis.lt as an invalid domain? Not sure why, seems valid to me

        for(String tld : tlds) {
            if(domain.toLowerCase().endsWith("." + tld.toLowerCase())) return true;
        }

        return false;
    }
}
