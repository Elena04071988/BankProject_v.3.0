import BankProject.actions.*;
import BankProject.exceptions.BankException;
import BankProject.interfaces.Printable;
import BankProject.menu.Application;
import BankProject.models.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static BankProject.models.AbstractCredit.printCredit;

public class Main {
    public static void main(String[] args) throws BankException {
        System.out.println("Hello world!");

       /* AbstractCredit c1 = new ConsumerCredit("For everyone", 10000, 25, 18, true, true, false, true, 13.5);
        AbstractCredit c2 = new CreditToCard("The best from the west", 50000, 50, 18, true, false, false, false, 10);
        AbstractCredit c3 = new HousingCredit("New house", 50000000, 12, 360, false, false, true, true, true);
        AbstractCredit c4 = new HousingCredit("Old house", 1000000, 10, 360, false, false, true, true, true);
        List<AbstractCredit> abstractCredits = new ArrayList<>();
        List<AbstractCredit> abstractCredits2 = new ArrayList<>();

        abstractCredits.add(c1);
        abstractCredits.add(c2);
        abstractCredits.add(c3);

        abstractCredits2.add(c1);
        abstractCredits2.add(c4);



        printCredit(abstractCredits);
        Bank b1 = new Bank("Alfa bank", "1234567", abstractCredits);
        Bank b2 = new Bank("Prior-bank", "1234567", abstractCredits2);
        List<Bank> bankList = new ArrayList<>();
        bankList.add(b1);
        bankList.add(b2);

        ObjectSerialization.writeToFile("banks.txt", bankList);

        System.out.println("-------------***--------------");

        List <Bank> newList = ObjectSerialization.readFromFile("banks.txt");
        System.out.println("Print from file first use toString() from Object");
        System.out.println(newList.toString());
        System.out.println("-------------***--------------");
        System.out.println("Print from file first use  our class Printer");
      //  Printer.PrintSet(newList);*/

        Collection<OneBankOneCredit> bankCollection = ReadFromFile.parseFile("bank1.txt");
        Printer.PrintSet(bankCollection);
        System.out.println("-------------***--------------");
        OneBankOneCredit.banksInfo(bankCollection);






        /*for (Bank b: newList) {
            System.out.printf("Bank: %s", "BIC: %s", b.getBankName(), b.getBIC());
            for (AbstractCredit c: b.getCredit()) {
                System.out.printf("CreditName: %s", "CreditPercent: %s",  c.getCreditName(), c.getRate());
            }
        }*/


        System.out.println("\nFinder");
        Collection<OneBankOneCredit> resultFinder = Finder.findCreditByAmountByRateAndCreditTerm(bankCollection, 1000.0, 0.15, 20);
        Printer.PrintSet(resultFinder);


        System.out.println("\nSorter");
        Collection<OneBankOneCredit> resultSorterByBankName = BankNameSorter.byBankName(bankCollection);
        Printer.PrintSet(resultSorterByBankName);





        Application application = new Application();


    }


}