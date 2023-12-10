package BankProject.actions;

import BankProject.models.OneBankOneCredit;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public class BankNameSorter {

    public static Collection<OneBankOneCredit> byBankName(Collection<OneBankOneCredit> oneBankOneCredits){
        SortedSet<OneBankOneCredit> resultSet = new TreeSet<>(new BankNameComparator());
         resultSet.addAll(oneBankOneCredits);
        return resultSet;
    }
}
