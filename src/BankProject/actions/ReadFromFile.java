package BankProject.actions;

import BankProject.enums.CreditNameEnum;
import BankProject.exceptions.BankException;
import BankProject.models.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;




public class ReadFromFile {
    public static Collection<OneBankOneCredit> parseFile(String filePath) {
        Collection<OneBankOneCredit> bankCollection = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();//для пропуска 1-й строки
            while ((line = br.readLine()) != null) {

                // Split the line into String creditName, double amount, double rate, int creditTerm, boolean earlyClosePossibility, boolean increaseCreditLimit, boolean salaryCertificate
                String[] parts = line.split(", ");

                // Extract data from parts and create a new BANK object
                String bankName = parts[0];
                String BIC = String.valueOf(parts[1].split(", ")[0]);
                CreditNameEnum creditNameEnum = CreditNameEnum.valueOf(parts[2].split(", ")[0]);
                double amount = Double.parseDouble(parts[3].split(", ")[0]);
                double rate = Double.parseDouble(parts[4].split(", ")[0]);
                int creditTerm = Integer.parseInt(parts[5].split(", ")[0]);
                boolean earlyClosePossibility = Boolean.parseBoolean((parts[6].split(", ")[0]));
                boolean increaseCreditLimit = Boolean.parseBoolean((parts[7].split(", ")[0]));
                boolean salaryCertificate = Boolean.parseBoolean((parts[8].split(", ")[0]));

                //String stringDefinitionName = creditNameEnum.name().toUpperCase();//FOR definition special line
                    switch (creditNameEnum.name()){
                        case "CONSUMERCREDIT":{
                            boolean purchaseBelarusianGoods = Boolean.parseBoolean((parts[9].split(", ")[0]));
                            double reducedRate = Double.parseDouble(parts[10].split(", ")[0]);
                            // Create a new Bank object
                            OneBankOneCredit bank = new OneBankOneCredit(bankName, BIC,
                                    new ConsumerCredit(creditNameEnum,
                                            amount,
                                            rate,
                                            creditTerm,
                                            earlyClosePossibility,
                                            increaseCreditLimit,
                                            salaryCertificate,
                                            purchaseBelarusianGoods,
                                            reducedRate));
                            //And add it to the list of banks
                            bankCollection.add(bank);
                            break;
                        }
                        case "CREDITTOCARD":{
                            boolean onlineRegistration = Boolean.parseBoolean((parts[9].split(", ")[0]));
                            double cardIssueCost = Double.parseDouble(parts[10].split(", ")[0]);
                            // Create a new Bank object
                            OneBankOneCredit bank = new OneBankOneCredit(bankName, BIC,
                                    new CreditToCard(creditNameEnum,
                                            amount,
                                            rate,
                                            creditTerm,
                                            earlyClosePossibility,
                                            increaseCreditLimit,
                                            salaryCertificate,
                                            onlineRegistration,
                                            cardIssueCost));
                            //And add it to the list of banks
                            bankCollection.add(bank);
                            break;
                        }
                        case "HOUSINGCREDIT":{
                            boolean securedByHousing = Boolean.parseBoolean((parts[9].split(", ")[0]));
                            boolean gracePeriod = Boolean.parseBoolean((parts[10].split(", ")[0]));
                            // Create a new Bank object
                            OneBankOneCredit bank = new OneBankOneCredit(bankName, BIC,
                                    new HousingCredit(creditNameEnum,
                                            amount,
                                            rate,
                                            creditTerm,
                                            earlyClosePossibility,
                                            increaseCreditLimit,
                                            salaryCertificate,
                                            securedByHousing,
                                            gracePeriod));
                            //And add it to the list of banks
                            bankCollection.add(bank);
                            break;
                        }

                        default:{
                            System.out.println("Problem with reading file");
                        }
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BankException e) {
            throw new RuntimeException(e);
        }
        return bankCollection;
    }

}
