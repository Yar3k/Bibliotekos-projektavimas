package com.vartotojai;
/**
 * Vartotojo object
 * */
public class Vartotojas {
    int userID;
    String vardas;
    String pavarde;
    String numeris;
    String email;
    String adresas;
    String slaptazodis;

    public Vartotojas (int id, String vardas, String pavarde, String numeris, String email, String adresas, String slaptazodis){
        this.userID = id;
        this.vardas=vardas;
        this.pavarde=pavarde;
        this.numeris=numeris;
        this.email=email;
        this.adresas=adresas;
        this.slaptazodis=slaptazodis;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getNumeris() {
        return numeris;
    }

    public void setNumeris(String numeris) {
        this.numeris = numeris;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresas() {
        return adresas;
    }

    public void setAdresas(String adresas) {
        this.adresas = adresas;
    }

    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }
}
