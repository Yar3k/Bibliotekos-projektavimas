package com.main;

import com.lib.EmailValidator;
import com.lib.PasswordChecker;
import com.vartotojai.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        menu();

    }
    public static void menu(){
        System.out.println("Pasirinkite:");
        System.out.println("1. Prideti vartotoja");
        System.out.println("2. Gauti vartotoja");
        System.out.println("3. Redakuoti vartotoja");
        System.out.println("4. Istrinti vartotoja");
        System.out.println("0. Baigti darba");
        String param = null;
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
                    param = reader.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        }
        switch (param){
            case "0":
                System.exit(0);
                break;
            case "1":
                Add();
                break;
            case "2":
                Get();
                break;
            case "3":
                Edit();
                break;
            case "4":
                Delete();
                break;
            default:
                System.out.println("Bad selection!");
                break;
        }
        menu();
    }

    public static void Add(){
        System.out.println("Parasykite varda,pavarde,numeri,saliesKoda(pvz:LT),elpasta,adresa,slaptazodi (atskirkite kableliu):");
        String name = null;
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            name = reader.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] data = name.split(",");
        Veiksmai veiksmai = new Veiksmai();
        int err=veiksmai.Prideti (data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
        switch (err){
            case 0:
                System.out.println("Prideta");
                break;
            case 1:
                System.out.println("Nurodytas blogas numeris arba salies kodas");
                break;
            case 2:
                System.out.println("Nurodytas blogas pastas");
                break;
            case 3:
                System.out.println("Blogas slaptazodis");
                break;
            default:
                System.out.println("Kazkas blogai");
        }

    }
    public static void Get(){
        System.out.println("Nurodykite vartotojo ID:");
        int id = 0;
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            id = Integer.parseInt(reader.readLine());

        } catch (Exception e) {
            System.out.println("Blogas id");
            return;
        }
        Veiksmai veiksmai = new Veiksmai();
        Vartotojas vartotojas = veiksmai.Istraukti(id);
        System.out.println("Vartotojas:"+
                " Vardas: " + vartotojas.getVardas()+
                " Pavarde: " + vartotojas.getPavarde()+
                " Numeris: " + vartotojas.getNumeris()+
                " El pastas: " + vartotojas.getEmail()+
                " Adresas: " + vartotojas.getAdresas()+
                " Slaptazodis: " + vartotojas.getSlaptazodis());

    }
    public static void Edit(){
        System.out.println("Nurodykite vartotojo ID:");
        int id = 0;
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            id = Integer.parseInt(reader.readLine());

        } catch (Exception e) {
            System.out.println("Blogas id");
            return;
        }
        System.out.println("Parasykite varda,pavarde,numeri,saliesKoda(pvz:LT),elpasta,adresa,slaptazodi (atskirkite kableliu):");
        String name = null;
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            name = reader.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] data = name.split(",");
        Veiksmai veiksmai = new Veiksmai();
        int err=veiksmai.Redakuoti (id, data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
        switch (err){
            case 0:
                System.out.println("Pakeista");
                break;
            case 1:
                System.out.println("Nurodytas blogas numeris arba salies kodas");
                break;
            case 2:
                System.out.println("Nurodytas blogas pastas");
                break;
            case 3:
                System.out.println("Blogas slaptazodis");
                break;
            case 4:
                System.out.println("Blogas id");
                break;
            default:
                System.out.println("Kazkas blogai");
        }
    }
    public static void Delete(){
        System.out.println("Nurodykite vartotojo ID:");
        int id = 0;
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            id = Integer.parseInt(reader.readLine());

        } catch (Exception e) {
            System.out.println("Blogas id");
            return;
        }
        Veiksmai veiksmai = new Veiksmai();
        veiksmai.Istrinti(id);
        System.out.println("Istrinta");
    }
}
