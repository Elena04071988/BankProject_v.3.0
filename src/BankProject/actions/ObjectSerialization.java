package BankProject.actions;

import BankProject.models.Bank;
import BankProject.models.OneBankOneCredit;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ObjectSerialization {
/*
    public static List<Bank> parseFile(String filePath) {
        List<Bank> bankList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into bankName, BIC, credit info
                String[] parts = line.split(",");

                // Extract data from parts and create a new Person object
                String bankName = parts[0];
                String BIC = String.valueOf(parts[1].split(","));
                String loanName = String.valueOf(parts[2].split(","));
                double amount = Double.parseDouble(parts[3].split(",")[2]);
                double rate = Double.parseDouble(parts[4].split(",")[3]);
                int loanTerm = Integer.parseInt(parts[5].split(",")[4]);



                private int loanTerm;//Срок кредита (в месяцах).
                private boolean earlyClosePossibility;//Возможность досрочного продления.
                private boolean increaseCreditLimit;//Возможность увеличения кредитного лимита.
                private boolean salarySertificate;


                double height = Double.parseDouble(parts[2].split(" ")[1]);

                // Create a new Person object and add it to the list
                Person person = new Person(name, age, height, married);
                personList.add(person);
            }



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bankList;
    }

    public static void writeToFile(String fileName, Collection<? extends Bank> array){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(array);
            System.out.println("Object saved");
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<Bank> readFromFile(String fileName){
        ArrayList<Bank> readArray = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            readArray = (ArrayList<Bank>) ois.readObject();
        }
        catch (IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return readArray;
    }
*/

    public static void writeToFileSecond(String fileName, Collection<? extends OneBankOneCredit> array){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(array);
            System.out.println("Object saved");
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static Collection<OneBankOneCredit> readFromFileSecond(String fileName){
        Collection<OneBankOneCredit> readArray = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            readArray = (Collection<OneBankOneCredit>) ois.readObject();
        }
        catch (IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return readArray;
    }


}
