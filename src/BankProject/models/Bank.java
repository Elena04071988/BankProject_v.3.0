package BankProject.models;

import BankProject.enums.BankEnum;
import BankProject.interfaces.Printable;
import BankProject.actions.*;
import BankProject.exceptions.*;
import java.io.Serializable;
import java.util.*;

public class Bank implements Printable, Serializable {
    private String bankName; //Название банка.
    //BankEnum bankEnum;
    private String BIC; //BIC банка
    private List<AbstractCredit> abstractCreditList; //список кредитов банка
    //private SortedSet<Credit> sortedCredits;

    {
        abstractCreditList = new ArrayList<>();
    }

    public Bank(String name, String bic, List<AbstractCredit> abstractCreditList) throws BankException {
        setBankName(name);
        setBIC(bic);
        setCreditList(abstractCreditList);
    }

    private void setBankName(String name) throws BankException {
        if(name == null || name.trim().isEmpty() || name.length() < 2)
            throw new BankException("Wrong Bank Name Value", this);
        this.bankName = name.substring(0,1).toUpperCase() + name.substring(1);
    }

    public String getBankName(){
        return bankName;
    }

    private void setBIC(String bic) throws BankException {
        if(bic == null || bic.trim().isEmpty() || bic.length() < 5)
            throw new BankException("Wrong BIC Value", this);
        this.BIC = bic;
    }


    public void setCreditList(List<AbstractCredit> abstractCreditList) {
        this.abstractCreditList = abstractCreditList;
    }

    public String getBIC(){
        return BIC;
    }

    public Collection<AbstractCredit> getCredit(){return abstractCreditList;}
//Переопределение hashCode в Java является важным шагом при реализации методов equals и hashCode для классов. Это необходимо для того, чтобы правильно хранить объекты в хэш-таблицах, например, в HashSet, HashMap и т.д.
//
//Правильное переопределение hashCode в Java должно учитывать все поля, которые участвуют в методе equals, и должно использовать одинаковый алгоритм вычисления для всех объектов класса.
    @Override
    public boolean equals(Object obj){
        if(this == obj){ return true;}
        if(obj == null || obj.getClass() != this.getClass()){
            return  false;
        }
        Bank bank = (Bank) obj;
        return this.BIC == bank.BIC && Objects.equals(this.bankName, bank.getBankName());
    }
//В этом примере hashCode использует метод Objects.hash(), который генерирует хэш-код на основе переданных ему аргументов.
//В аргументах перечислены все поля класса, которые участвуют в методе equals. Если вы добавите новое поле в класс, которое также должно участвовать в методе equals, не забудьте добавить его и в hashCode
    @Override
    public int hashCode(){
        return Objects.hash(getBankName(), getBIC());
    }

@Override
    public String toString(){
        String creditsString = "\tCredits:\n";
        int i = 0;
        for (AbstractCredit c: this.abstractCreditList) {
            creditsString += "\t" + c.toString() + "\n";
        }
        return String.format("\nBank name: %s, \n%s", getBankName(), creditsString);
    }

    public void print() throws BankException{
        System.out.printf("Bank name: %s, BIC: %s\n", bankName, BIC);
        System.out.println("Credits:");
        Printer.PrintSet(abstractCreditList);
    }


    public static void printAllBanks(Collection<Bank> bankCollection) throws BankException {
        for (Bank b: bankCollection) {
            System.out.println("Bank: " + b.getBankName());
            System.out.println("BIC: " + b.getBIC());
            Printer.PrintSet(b.abstractCreditList);
        }
    }

}
