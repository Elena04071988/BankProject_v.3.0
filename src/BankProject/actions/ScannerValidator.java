package BankProject.actions;

import java.util.Scanner;

public class ScannerValidator {
     static Scanner sc = new Scanner(System.in);
    public static double keyValidationDouble(String message, double min, double max, String message2) {
        double numberValidate = 0.0;
        Scanner sc = new Scanner(System.in);
        System.out.println(message + " from " + min + " to " + max + message2);
       // while (!sc.hasNextDouble() || (numberValidate = sc.nextDouble()) > max || numberValidate < min) {
           numberValidate = sc.nextDouble();
        //    System.out.println("Invalid input, try again");
          //  System.out.println(message + " from " + min + " to " + max + message2);
        //}
        sc.close();
        return numberValidate;
    }

    public static int keyValidationInt(String message, int min, int max, String message2) {
        int numberValidate = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println(message + " from " + min + " to " + max + message2);
       // while (!sc.hasNextInt()|| (numberValidate = sc.nextInt()) < 0) {
            numberValidate = sc.nextInt();
       //     System.out.println("Invalid input, try again");
            System.out.println(message + " from " + min + " to " + max + message2);
       // }
        sc.close();
        return numberValidate;
    }


}
