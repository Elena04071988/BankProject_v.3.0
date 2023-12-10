package BankProject.controls;

import BankProject.interfaces.BankOperationable;
import BankProject.models.OneBankOneCredit;


import java.util.Collection;

public class BankController implements BankOperationable<OneBankOneCredit> {

    Collection<OneBankOneCredit> oneBankOneCredits;


    @Override
    public OneBankOneCredit save(OneBankOneCredit entity) {
        oneBankOneCredits.add(entity);
        return entity;
    }

    @Override
    public void delete(OneBankOneCredit entity) {
        oneBankOneCredits.remove(entity);
    }
}
