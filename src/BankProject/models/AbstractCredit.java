package BankProject.models;

import BankProject.enums.CreditNameEnum;
import BankProject.interfaces.Printable;
import BankProject.exceptions.*;
import java.io.Serializable;
import java.util.Collection;

public abstract class AbstractCredit implements Printable, Serializable/*, Comparable<Credit> */{
    //private String creditName;//Название кредита
    private CreditNameEnum creditNameEnum;//Название кредита

    //Название банка.
    private double amount; //Сумма кредита.
    private double rate;//Процентная ставка по кредиту.
    private int creditTerm;//Срок кредита (в месяцах).
    private boolean earlyClosePossibility;//Возможность досрочного продления.
    private boolean increaseCreditLimit;//Возможность увеличения кредитного лимита.
    private boolean salaryCertificate;
    //Другие параметры, важные для рассмотрения кредита.

    public AbstractCredit(CreditNameEnum creditNameEnum, double amount, double rate, int creditTerm, boolean earlyClosePossibility, boolean increaseCreditLimit, boolean salaryCertificate) throws BankException{
        this.creditNameEnum = creditNameEnum;
        this.amount = amount;
        this.rate = rate;
        this.creditTerm = creditTerm;
        this.earlyClosePossibility = earlyClosePossibility;
        this.increaseCreditLimit = increaseCreditLimit;
        this.salaryCertificate = salaryCertificate;
    }


    public AbstractCredit(CreditNameEnum creditNameEnum, double amount, int creditTerm, boolean earlyClosePossibility, boolean increaseCreditLimit, boolean salaryCertificate) throws BankException{
        this.creditNameEnum = creditNameEnum;
        this.amount = amount;
        this.creditTerm = creditTerm;
        this.earlyClosePossibility = earlyClosePossibility;
        this.increaseCreditLimit = increaseCreditLimit;
        this.salaryCertificate = salaryCertificate;
    }

   /* public String getCreditNameEnum() throws BankException {
        if(creditNameEnum == null || creditNameEnum.trim().isEmpty() || creditNameEnum.length() < 2)
            throw new BankException("Wrong name value", this);
        this.creditName = creditName.substring(0,1).toUpperCase() + creditName.substring(1);
        return creditName;
    }*/

    public CreditNameEnum getCreditNameEnum() throws BankException {
        if(creditNameEnum == null || creditNameEnum.getDescription() == null)
            throw new BankException("Wrong name value", this);
        return creditNameEnum;
    }


    public void setCreditNameEnum(CreditNameEnum creditNameEnum) {
        this.creditNameEnum = creditNameEnum;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(int creditTerm) {
        this.creditTerm = creditTerm;
    }

    public boolean isEarlyClosePossibility() {
        return earlyClosePossibility;
    }

    public void setEarlyClosePossibility(boolean earlyClosePossibility) {
        this.earlyClosePossibility = earlyClosePossibility;
    }

    public boolean isIncreaseCreditLimit() {
        return increaseCreditLimit;
    }

    public void setIncreaseCreditLimit(boolean increaseCreditLimit) {
        this.increaseCreditLimit = increaseCreditLimit;
    }

    public boolean isSalaryCertificate() {
        return salaryCertificate;
    }

    public void setSalaryCertificate(boolean salaryCertificate) {
        this.salaryCertificate = salaryCertificate;
    }

    @Override
    public String toString() {
        try {
            return "Credit{" +
                    "creditName='" + getCreditNameEnum().getDescription() + '\'' +
                    ", amount=" + getAmount() +
                    ", rate=" + getRate() +
                    ", creditTerm=" + getCreditTerm() +
                    ", earlyClosePossibility=" + isEarlyClosePossibility() +
                    ", increaseCreditLimit=" + isIncreaseCreditLimit() +
                    ", salaryCertificate=" + isSalaryCertificate() +
                    '}';
        } catch (BankException e) {
            throw new RuntimeException(e);
        }
    }

@Override
    public void print() throws BankException {
        print();
         System.out.println(getCreditNameEnum().getDescription() + getAmount() + getCreditTerm() + getRate());
        //System.out.printf("Credit name: %s", "Amount: %d", creditName, getAmount());

    }
    public static void printCredit(Collection<AbstractCredit> abstractCredits) throws BankException {
        for (AbstractCredit c: abstractCredits) {
            System.out.println(c.toString());
            System.out.println("\n");
        }
    }
}
