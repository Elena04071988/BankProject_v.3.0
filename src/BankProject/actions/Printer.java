package BankProject.actions;

import BankProject.exceptions.BankException;
import BankProject.interfaces.*;

import java.util.Collection;

public class Printer {
    public static void PrintSet(Collection<? extends Printable> array) throws BankException {
        for(Printable p: array) p.print();
        System.out.println("\n");
    }
}
