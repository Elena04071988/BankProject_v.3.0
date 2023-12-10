package BankProject.enums;

public enum CreditNameEnum {

    HOUSINGCREDIT("Ipoteka"),
    CREDITTOCARD("On card"),
    CONSUMERCREDIT("For consumer");

    private String description;

    CreditNameEnum(String description){
        this.description = description;
    }
    public String getDescription(){return description;}



    public static boolean isValid(String str){
        try{
            return CreditNameEnum.valueOf(str) !=null;
        }
        catch (Exception e) {return  false;}
    }

}
