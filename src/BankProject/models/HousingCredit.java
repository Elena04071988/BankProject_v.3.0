package BankProject.models;

import BankProject.enums.CreditNameEnum;
import BankProject.exceptions.BankException;

import java.io.Serializable;

//на жилье
public class HousingCredit extends AbstractCredit implements Serializable {

    //под залог жилья
    private boolean securedByHousing;
    private boolean gracePeriod;


    public HousingCredit(CreditNameEnum creditNameEnum, double amount, double rate, int creditTerm, boolean earlyClosePossibility, boolean increaseCreditLimit, boolean salarySertificate, boolean securedByHousing, boolean gracePeriod) throws BankException {
        super(creditNameEnum, amount, rate, creditTerm, earlyClosePossibility, increaseCreditLimit, salarySertificate);
        this.securedByHousing = securedByHousing;
        this.gracePeriod = gracePeriod;
    }

    public boolean isSecuredByHousing() {
        return securedByHousing;
    }

    public void setSecuredByHousing(boolean securedByHousing) {
        this.securedByHousing = securedByHousing;
    }

    public boolean isGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(boolean gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    @Override
    public void print() throws BankException {
        System.out.println(getCreditNameEnum().getDescription() + "\t\t" +
                getAmount() + "\t\t" +
                getRate() + "\t" +
                getCreditTerm() + "\t\t" +
                isEarlyClosePossibility() + "\t\t" +
                isIncreaseCreditLimit() + "\t\t" +
                isSalaryCertificate() + "\t\t\t" +
                isSecuredByHousing() + "\t\t" +
                isGracePeriod());
    }

}

