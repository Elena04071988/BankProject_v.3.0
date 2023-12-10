package BankProject.models;
//потребительский

import BankProject.enums.CreditNameEnum;
import BankProject.exceptions.BankException;

import java.io.Serializable;

public class ConsumerCredit extends AbstractCredit implements Serializable {

//На приобретение товаров, произведенных в рб Пониженная процентная ставка
    private boolean purchaseBelarusianGoods;
    private double reducedRate;//размер пониженной ставки


    public ConsumerCredit(CreditNameEnum creditNameEnum, double amount, double rate, int creditTerm, boolean earlyClosePossibility, boolean increaseCreditLimit, boolean salaryCertificate, boolean purchaseBelarusianGoods, double reducedRate) throws BankException{
        super(creditNameEnum, amount, rate, creditTerm, earlyClosePossibility, increaseCreditLimit, salaryCertificate);
        this.purchaseBelarusianGoods = purchaseBelarusianGoods;
        this.reducedRate = reducedRate;
    }

    public boolean isPurchaseBelarusianGoods() {
        return purchaseBelarusianGoods;
    }

    public void setPurchaseBelarusianGoods(boolean purchaseBelarusianGoods) {
        this.purchaseBelarusianGoods = purchaseBelarusianGoods;
    }

    public double getReducedRate() {
        return reducedRate;
    }

    public void setReducedRate(double reducedRate) {
        this.reducedRate = reducedRate;
    }

    @Override
    public void print() throws BankException {
        System.out.println(getCreditNameEnum().getDescription() +"\t\t"+
                getAmount() +"\t\t"+
                getRate() +"\t"+
                getCreditTerm() +"\t\t"+
                isEarlyClosePossibility() +"\t\t"+
                isIncreaseCreditLimit() +"\t\t"+
                isSalaryCertificate() +"\t\t\t"+
                isPurchaseBelarusianGoods() +"\t\t"+
                getReducedRate());
    }

}
