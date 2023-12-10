package BankProject.actions;


import BankProject.exceptions.BankException;
import BankProject.models.OneBankOneCredit;

import java.util.ArrayList;
import java.util.Collection;

public class Finder {
    public static OneBankOneCredit findBankByName(Collection<OneBankOneCredit> bankCreditCollection, String variable){
        for (OneBankOneCredit o: bankCreditCollection) {
            if(o.getBankName().equals(variable))
                return o;
        }
        return null;
    }

    public static Collection<OneBankOneCredit> findCollectionByNameAndCreditByName(Collection<OneBankOneCredit> bankCreditCollection, String findBankName, String findCreditName) throws BankException {
        Collection<OneBankOneCredit> newCollection = new ArrayList<>();
        for (OneBankOneCredit o: bankCreditCollection) {
            if(o.getBankName().equals(findBankName) && o.getAbstractCredit().getCreditNameEnum().equals(findCreditName.toUpperCase()))
                newCollection.add(o);
        }
        return newCollection;
    }

    public static OneBankOneCredit findBankByNameAndCreditByName(Collection<OneBankOneCredit> bankCreditCollection, String findBankName, String findCreditName) throws BankException {
       for (OneBankOneCredit o: bankCreditCollection) {
            if(o.getBankName().equals(findBankName) && o.getAbstractCredit().getCreditNameEnum().equals(findCreditName.toUpperCase()))
                return o;
        }
        return null;
    }

    public static OneBankOneCredit findCreditByRate(Collection<OneBankOneCredit> bankCreditCollection, Double rate){
        for (OneBankOneCredit o: bankCreditCollection) {
            if(o.getAbstractCredit().getRate() == rate){
                return o;
            }
        }
        return null;
    }

    public static Collection<OneBankOneCredit> findCreditByAmountByRate(Collection<OneBankOneCredit> bankCreditCollection, Double amount, Double rate){
        Collection<OneBankOneCredit> newCollect = new ArrayList<>();
        for (OneBankOneCredit o: bankCreditCollection) {
            if(o.getAbstractCredit().getAmount()>= amount && o.getAbstractCredit().getRate() == rate){
                newCollect.add(o);
            }
        }
        return newCollect;
    }

    public static Collection<OneBankOneCredit> findCreditByAmountByRateAndCreditTerm(Collection<OneBankOneCredit> bankCreditCollection, Double amount, Double rate, int creditTerm){
        Collection<OneBankOneCredit> newCollect = new ArrayList<>();
        for (OneBankOneCredit o: bankCreditCollection) {
            if(o.getAbstractCredit().getAmount()>= amount && o.getAbstractCredit().getRate() == rate && o.getAbstractCredit().getCreditTerm() >= creditTerm){
                newCollect.add(o);
            }
        }
        return newCollect;
    }
}
