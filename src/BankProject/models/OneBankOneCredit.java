package BankProject.models;

import BankProject.exceptions.BankException;
import BankProject.interfaces.Printable;

import java.io.Serializable;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public class OneBankOneCredit implements Printable, Serializable {

    private String bankName; //Название банка.
    //BankEnum bankEnum;
    private String BIC; //BIC банка
    private AbstractCredit abstractCredit; // кредит банка

    SortedSet<OneBankOneCredit> bankSortedSet;
    {
        bankSortedSet = new TreeSet<>();
    }

    public OneBankOneCredit() {
    }

    public OneBankOneCredit(String bankName, String BIC, AbstractCredit abstractCredit) throws BankException{
        setBankName(bankName);
        setBIC(BIC);
        this.abstractCredit = abstractCredit;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) throws BankException{
        if(bankName == null || bankName.trim().isEmpty() || bankName.length() < 2)
            throw new BankException("Wrong Bank Name Value", this);
        this.bankName = bankName.substring(0,1).toUpperCase() + bankName.substring(1);
    }


    public void setBIC(String BIC) throws BankException{
        if(BIC == null || BIC.trim().isEmpty() || BIC.length() < 5)
            throw new BankException("Wrong BIC Value", this);
        this.BIC = BIC;
    }

    public String getBIC() {
        return BIC;
    }

    public AbstractCredit getAbstractCredit() {
        return abstractCredit;
    }

    public static void banksInfo(Collection<OneBankOneCredit> oneBankOneCredits) throws BankException{
        System.out.print("Bank name:\t\t\tBIC\t\tCredit name:\t\tAmount\t\trate\tterm\tclose+/-\tincrease\tcertificate\n");
        oneBankOneCredits.forEach(oneBankOneCredit -> {
            try {
                oneBankOneCredit.print();
            } catch (BankException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void print() throws BankException {
        System.out.print(getBankName() + "\t\t" + getBIC() + "\t\t");
        abstractCredit.print();
    }
}
