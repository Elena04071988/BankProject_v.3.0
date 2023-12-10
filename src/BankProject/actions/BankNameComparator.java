package BankProject.actions;

import BankProject.models.OneBankOneCredit;

import java.util.Comparator;

public class BankNameComparator implements Comparator<OneBankOneCredit> {
    @Override
    public int compare(OneBankOneCredit o1, OneBankOneCredit o2) {
        return o1.getBankName().compareTo(o2.getBankName());
    }
}
