package BankProject.models;

import BankProject.enums.CreditNameEnum;
import BankProject.exceptions.BankException;

import java.io.Serializable;

//на карту
public class CreditToCard extends AbstractCredit implements Serializable {

    private boolean onlineRegistration;//Оформление онлайн
    private double cardIssueCost; //стоимость выпуска карты

    public CreditToCard(CreditNameEnum creditNameEnum, double amount, double rate, int creditTerm, boolean earlyClosePossibility, boolean increaseCreditLimit, boolean salarySertificate, boolean onlineRegistration, double cardIssueCost) throws BankException {
        super(creditNameEnum, amount, rate, creditTerm, earlyClosePossibility, increaseCreditLimit, salarySertificate);
        this.onlineRegistration = onlineRegistration;
        this.cardIssueCost = cardIssueCost;
    }

    public boolean isOnlineRegistration() {
        return onlineRegistration;
    }

    public void setOnlineRegistration(boolean onlineRegistration) {
        this.onlineRegistration = onlineRegistration;
    }

    public double getCardIssueCost() {
        return cardIssueCost;
    }

    public void setCardIssueCost(double cardIssueCost) {
        this.cardIssueCost = cardIssueCost;
    }

    @Override
    public void print() throws BankException{
        System.out.println(getCreditNameEnum().getDescription() +"\t\t"+
                getAmount() +"\t\t"+
                getRate() +"\t"+
                getCreditTerm() +"\t\t"+
                isEarlyClosePossibility() +"\t\t"+
                isIncreaseCreditLimit() +"\t\t"+
                isSalaryCertificate() +"\t\t\t"+
                isOnlineRegistration() +"\t\t"+
                getCardIssueCost());
    }

}
