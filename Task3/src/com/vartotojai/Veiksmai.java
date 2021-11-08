package com.vartotojai;
/**
 * Library actions (add, get, delete, edit)
 * */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Veiksmai {
    List<Vartotojas> list = new ArrayList<Vartotojas>();
    Vartotojas temp;
    Validators validate = new Validators();
    public Veiksmai(){
        String row;
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("src/com/vartotojai/list.csv"));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                temp = new Vartotojas(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6]);
                list.add(temp);
            }
            csvReader.close();
        }catch (Exception e){
            System.out.println("File could not be readed");
        }
    }
    public int Prideti(String vardas, String pavarde, String numeris, String saliesKodas, String email, String adresas, String slaptazodis){
        int errcode = ValidateAll(numeris, saliesKodas, email, slaptazodis);
        if (errcode!=0) return errcode;

        temp = new Vartotojas(idGenerator(list), vardas,pavarde,validate.NumberFormatChanger(numeris),email,adresas,slaptazodis);
        list.add(temp);
        SaveList(list);
        return 0;
    }

    public void Istrinti(int id){
        for (Vartotojas zmogus:list) {
            if (zmogus.getUserID()==id) {
                list.remove(zmogus);
                SaveList(list);
                break;
            }
        }
    }

    public Vartotojas Istraukti(int id){
        for (Vartotojas zmogus:list) {
            if (zmogus.getUserID()==id) {
                return zmogus;
            }
        }
        return null;
    }

    public int Redakuoti(int id, String vardas, String pavarde, String numeris, String saliesKodas, String email, String adresas, String slaptazodis){
        int errcode = ValidateAll(numeris, saliesKodas, email, slaptazodis);
        if (errcode!=0) return errcode;
        temp = new Vartotojas(id, vardas, pavarde, numeris,email,adresas,slaptazodis);
        for (Vartotojas zmogus:list) {
            if (zmogus.getUserID()==id) {
                list.set(list.indexOf(zmogus), temp);
                SaveList(list);
                return 0;
            }
        }
        return 4;//Not found
    }

    private int ValidateAll(String numeris, String saliesKodas, String email, String slaptazodis){
        if (!validate.ValidatePhone(numeris, saliesKodas)) return 1; //Bad phone number
        if (!validate.ValidateEmail(email)) return 2; //Bad email
        if (!validate.ValidatePassword(slaptazodis)) return 3; //Bad password
        return 0;
    }

    private void SaveList(List<Vartotojas> list){
        File myObj = new File("src/com/vartotojai/list.csv");
        myObj.delete();
        try {
            FileWriter csvWriter = new FileWriter("src/com/vartotojai/list.csv");

            for (Vartotojas person:list) {
                csvWriter.append(String.valueOf(person.getUserID()));
                csvWriter.append(",");
                csvWriter.append(person.getVardas());
                csvWriter.append(",");
                csvWriter.append(person.getPavarde());
                csvWriter.append(",");
                csvWriter.append(person.getNumeris());
                csvWriter.append(",");
                csvWriter.append(person.getEmail());
                csvWriter.append(",");
                csvWriter.append(person.getAdresas());
                csvWriter.append(",");
                csvWriter.append(person.getSlaptazodis());
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        }catch (Exception e){
            System.out.println("Failed saving file");
        }

    }

    private int idGenerator (List<Vartotojas> list){
        if (list.isEmpty()) return 0;
        return list.get(list.size() - 1).getUserID()+1;
    }
}
