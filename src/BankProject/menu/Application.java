package BankProject.menu;

import BankProject.actions.*;
import BankProject.enums.CreditNameEnum;
import BankProject.exceptions.BankException;
import BankProject.models.ConsumerCredit;
import BankProject.models.CreditToCard;
import BankProject.models.HousingCredit;
import BankProject.models.OneBankOneCredit;


import java.util.Collection;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;


public class Application {
    static Menu menu;
    public String password = "111111";

    public Application() {
        AtomicReference<Collection<OneBankOneCredit>> banks = new AtomicReference<>();
        try {
            Menu mainMenu = new Menu("Main Menu", "Bank structure");
            Menu subMenu = new Menu("Password", "get password");
            Menu subMenuLoad = new Menu("Load data", "load data from file");
            Menu submenuCreateBank = new Menu("Create bank", "Create bank and credit");

            //sub menu
            mainMenu.putAction("get password menu", () -> subMenu.activateMenu());
            mainMenu.putAction("load data menu", () -> subMenuLoad.activateMenu());
            mainMenu.putAction("Create and save bank to Collection menu", () -> submenuCreateBank.activateMenu());

            subMenu.putAction("get password", () -> System.out.println(password));
            subMenu.putAction("main menu", () -> mainMenu.activateMenu());
           // submenuCreateBank.putAction("main menu", ()-> mainMenu.activateMenu());

            subMenuLoad.putAction("load data from bank1.txt", () -> {
                try {
                    Collection<OneBankOneCredit> baseBanks = ReadFromFile.parseFile("bank1.txt");
                    banks.set(baseBanks);
                    System.out.println("Data loaded");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            });
            subMenuLoad.putAction("load data from JSON", () ->{
                banks.set(ObjectSerialization.readFromFileSecond("banks.json"));
                System.out.println("Data loaded");
            });
            subMenuLoad.putAction("main menu", ()-> mainMenu.activateMenu());

            submenuCreateBank.putAction("save bank and HOUSINGCREDIT", () -> {
                System.out.println("");//��������� ���� �� �������
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter bankName for saving (String)");
                String bankName = sc.nextLine();
                System.out.println("Enter banks BIC (String)");
                String BIC = sc.nextLine();
                System.out.println("Enter banks amount (100000,0)");
                double amount = sc.nextDouble();
                System.out.println("Enter banks rate (0,15)");
                double rate = sc.nextDouble();
                System.out.println("Enter banks creditTerm (int)");
                int creditTerm = sc.nextInt();
                System.out.println("Enter earlyClosePossibility (boolean)");
                boolean earlyClosePossibility = sc.nextBoolean();
                System.out.println("Enter increaseCreditLimit  (boolean)");
                boolean increaseCreditLimit = sc.nextBoolean();
                System.out.println("Enter salaryCertificate  (boolean)");
                boolean salaryCertificate = sc.nextBoolean();
                System.out.println("Enter securedByHousing  (boolean)");
                boolean securedByHousing = sc.nextBoolean();
                System.out.println("Enter gracePeriod  (boolean)");
                boolean gracePeriod = sc.nextBoolean();

                try {//������� ������
                    OneBankOneCredit newOneBankOneCredit = new OneBankOneCredit(bankName, BIC,
                            new HousingCredit(CreditNameEnum.HOUSINGCREDIT, amount, rate, creditTerm,
                                    earlyClosePossibility, increaseCreditLimit, salaryCertificate, securedByHousing, gracePeriod));
                    //�������� ������
                    banks.get().add(newOneBankOneCredit);

                    System.out.println("Result");
                    System.out.print("Bank name:\t\t\tCredit name:\t\tAmount\t\tRate\tterm\n");
                    banks.get().forEach(oneBankOneCredit -> {
                        try {
                            System.out.println(oneBankOneCredit.getBankName() + "\t\t\t" +
                                    oneBankOneCredit.getAbstractCredit().getCreditNameEnum().getDescription() + "\t\t" +
                                    oneBankOneCredit.getAbstractCredit().getAmount() + "\t\t" +
                                    oneBankOneCredit.getAbstractCredit().getRate() + "\t" +
                                    oneBankOneCredit.getAbstractCredit().getCreditTerm());

                        } catch (BankException e) {
                            throw new RuntimeException(e);
                        }
                    });
                } catch (BankException e) {
                    e.getMessage();
                }
            });

            submenuCreateBank.putAction("save bank and CREDITTOCARD", () -> {
                System.out.println("");//��������� ���� �� �������
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter bankName for saving (String)");
                String bankName = sc.nextLine();
                System.out.println("Enter banks BIC (String)");
                String BIC = sc.nextLine();
                //System.out.println("Enter creditName smt like as (CREDITTOCARD)");
                //String creditNameEnum = (CreditNameEnum)sc.nextLine();
                System.out.println("Enter banks amount (100000,0)");
                double amount = sc.nextDouble();
                System.out.println("Enter banks rate (0,15)");
                double rate = sc.nextDouble();
                System.out.println("Enter banks creditTerm (int)");
                int creditTerm = sc.nextInt();
                System.out.println("Enter earlyClosePossibility (boolean)");
                boolean earlyClosePossibility = sc.nextBoolean();
                System.out.println("Enter increaseCreditLimit  (boolean)");
                boolean increaseCreditLimit = sc.nextBoolean();
                System.out.println("Enter salaryCertificate  (boolean)");
                boolean salaryCertificate = sc.nextBoolean();
                System.out.println("Enter onlineRegistration  (boolean)");
                boolean onlineRegistration = sc.nextBoolean();
                System.out.println("Enter cardIssueCost  (like as 5,0)");
                double cardIssueCost = sc.nextDouble();

                try {//������� ������
                    OneBankOneCredit newOneBankOneCredit = new OneBankOneCredit(bankName, BIC,
                            new CreditToCard(CreditNameEnum.CREDITTOCARD, amount, rate, creditTerm,
                                    earlyClosePossibility, increaseCreditLimit, salaryCertificate, onlineRegistration, cardIssueCost));
                    //�������� ������
                    banks.get().add(newOneBankOneCredit);

                    System.out.println("Result");
                    System.out.print("Bank name:\t\t\tCredit name:\t\tAmount\t\tRate\tterm\n");
                    banks.get().forEach(oneBankOneCredit -> {
                        try {
                            System.out.println(oneBankOneCredit.getBankName() + "\t\t\t" +
                                    oneBankOneCredit.getAbstractCredit().getCreditNameEnum().getDescription() + "\t\t" +
                                    oneBankOneCredit.getAbstractCredit().getAmount() + "\t\t" +
                                    oneBankOneCredit.getAbstractCredit().getRate() + "\t" +
                                    oneBankOneCredit.getAbstractCredit().getCreditTerm());

                        } catch (BankException e) {
                            throw new RuntimeException(e);
                        }
                    });
                } catch (BankException e) {
                    throw new RuntimeException(e);
                }
            });

            submenuCreateBank.putAction("save bank and CONSUMERCREDIT", () -> {
                System.out.println("");//��������� ���� �� �������
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter bankName for saving (String)");
                String bankName = sc.nextLine();
                System.out.println("Enter banks BIC (String)");
                String BIC = sc.nextLine();
                //System.out.println("Enter creditName smt like as (CONSUMERCREDIT)");
                //String creditNameEnum = (CreditNameEnum)sc.nextLine();
                System.out.println("Enter banks amount (100000,0)");
                double amount = sc.nextDouble();
                System.out.println("Enter banks rate (0,15)");
                double rate = sc.nextDouble();
                System.out.println("Enter banks creditTerm (int)");
                int creditTerm = sc.nextInt();
                System.out.println("Enter earlyClosePossibility (boolean)");
                boolean earlyClosePossibility = sc.nextBoolean();
                System.out.println("Enter increaseCreditLimit  (boolean)");
                boolean increaseCreditLimit = sc.nextBoolean();
                System.out.println("Enter salaryCertificate  (boolean)");
                boolean salaryCertificate = sc.nextBoolean();
                System.out.println("Enter purchaseBelarusianGoods  (boolean)");
                boolean purchaseBelarusianGoods = sc.nextBoolean();
                System.out.println("Enter gracePeriod  (like as 0,05)");
                double reducedRate = sc.nextDouble();

                try {//������� ������
                    OneBankOneCredit newOneBankOneCredit = new OneBankOneCredit(bankName, BIC,
                            new ConsumerCredit(CreditNameEnum.CONSUMERCREDIT, amount, rate, creditTerm,
                                    earlyClosePossibility, increaseCreditLimit, salaryCertificate, purchaseBelarusianGoods, reducedRate));
                    //�������� ������
                    banks.get().add(newOneBankOneCredit);

                    System.out.println("Result");
                    System.out.print("Bank name:\t\t\tCredit name:\t\tAmount\t\tRate\tterm\n");
                    banks.get().forEach(oneBankOneCredit -> {
                        try {
                            System.out.println(oneBankOneCredit.getBankName() + "\t\t\t" +
                                    oneBankOneCredit.getAbstractCredit().getCreditNameEnum().getDescription() + "\t\t" +
                                    oneBankOneCredit.getAbstractCredit().getAmount() + "\t\t" +
                                    oneBankOneCredit.getAbstractCredit().getRate() + "\t" +
                                    oneBankOneCredit.getAbstractCredit().getCreditTerm());

                        } catch (BankException e) {
                            throw new RuntimeException(e);
                        }
                    });
                } catch (BankException e) {
                    throw new RuntimeException(e);
                }
            });

            submenuCreateBank.putAction("main menu", ()-> mainMenu.activateMenu());

            mainMenu.putAction("print banks info", () -> banks.get().forEach(oneBankOneCredit -> {
                try {
                    oneBankOneCredit.print();
                } catch (BankException e) {
                    throw new RuntimeException(e);
                }
            }));

            mainMenu.putAction("sorting banks program", () -> {
                try {
                    Collection<OneBankOneCredit> res = BankNameSorter.byBankName(banks.get());
                    System.out.println("Banks was sorted");
                    if (res.size() > 0) {
                        System.out.println("After sorting");
                        System.out.print("Bank name:\t\t\tCredit name:\t\tAmount\t\tRate\tterm\n");
                        res.forEach(oneBankOneCredit -> {
                            try {
                                System.out.println(oneBankOneCredit.getBankName() + "\t\t\t" +
                                        oneBankOneCredit.getAbstractCredit().getCreditNameEnum().getDescription() + "\t\t" +
                                        oneBankOneCredit.getAbstractCredit().getAmount() + "\t\t" +
                                        oneBankOneCredit.getAbstractCredit().getRate() + "\t" +
                                        oneBankOneCredit.getAbstractCredit().getCreditTerm());
                            } catch (BankException e) {
                                e.getMessage();
                            }
                        });
                    } else System.out.println("Unfortunately, we do not have any offers for your request.");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });


            mainMenu.putAction("find banks program", () -> {
                double amount = 0.0;
                double rate = 0.0;
                int creditTerm = 0;
                try {
                    amount = ScannerValidator.keyValidationDouble("Enter credit sum:", 100.0, 1000000.0, "");
                    rate = ScannerValidator.keyValidationDouble("Enter credit rate:", 0.01, 0.5, " like as 0,15");
                    creditTerm = ScannerValidator.keyValidationInt("Enter credit term:", 3, 360, " like as 36");

                   // Collection<OneBankOneCredit> res = Finder.findCreditByAmountByRateAndCreditTerm(banks.get(), 1000.0, 0.15, 30);

                    Collection<OneBankOneCredit> res = Finder.findCreditByAmountByRateAndCreditTerm(banks.get(), amount, rate, creditTerm);
                    if (res.size() > 0) {
                        System.out.println("These credits are right for you");
                        System.out.print("Bank name:\t\t\tCredit name:\t\tAmount\t\tRate\tterm\n");
                        res.forEach(oneBankOneCredit -> {
                            try {
                                System.out.println(oneBankOneCredit.getBankName() + "\t\t\t" +
                                        oneBankOneCredit.getAbstractCredit().getCreditNameEnum().getDescription() + "\t\t" +
                                        oneBankOneCredit.getAbstractCredit().getAmount() + "\t\t" +
                                        oneBankOneCredit.getAbstractCredit().getRate() + "\t" +
                                        oneBankOneCredit.getAbstractCredit().getCreditTerm());

                            } catch (BankException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    } else System.out.println("Unfortunately, we do not have any offers for your request.");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });


            mainMenu.putAction("delete bankByName", () -> {
                System.out.println("Enter the name of the bank we will remove");
                Scanner sc = new Scanner(System.in);
                String nameForDelete = sc.nextLine();
                Collection<OneBankOneCredit> oneBankOneCredits = banks.get();//�������� ��������� �������� ������

                OneBankOneCredit res2;
                //��������� ���� �� ����� ���� � //��������� � ������ ��� �������� ��������� �����
                res2 = Finder.findBankByName(oneBankOneCredits, nameForDelete);
                if (!(res2 == null)) {
                    oneBankOneCredits.remove(res2);
                    System.out.println("Bank was deleted");
                } else System.out.println("No one banks was founded for deleting");


                System.out.print("Bank name:\t\t\tCredit name:\t\tAmount\t\tRate\tterm\n");
                oneBankOneCredits.forEach(oneBankOneCredit -> {
                    try {
                        System.out.println(oneBankOneCredit.getBankName() + "\t\t\t" +
                                oneBankOneCredit.getAbstractCredit().getCreditNameEnum().getDescription() + "\t\t" +
                                oneBankOneCredit.getAbstractCredit().getAmount() + "\t\t" +
                                oneBankOneCredit.getAbstractCredit().getRate() + "\t" +
                                oneBankOneCredit.getAbstractCredit().getCreditTerm());

                    } catch (BankException e) {
                        throw new RuntimeException(e);
                    }
                });
            });


            mainMenu.putAction("Save data to JSON", () ->{
                ObjectSerialization.writeToFileSecond("banks.json", banks.get());
                System.out.println("Data was readed");

                System.out.print("Bank name:\t\t\tCredit name:\t\tAmount\t\tRate\tterm\n");
                banks.get().forEach(oneBankOneCredit -> {
                    try {
                        System.out.println(oneBankOneCredit.getBankName() + "\t\t\t" +
                                oneBankOneCredit.getAbstractCredit().getCreditNameEnum().getDescription() + "\t\t" +
                                oneBankOneCredit.getAbstractCredit().getAmount() + "\t\t" +
                                oneBankOneCredit.getAbstractCredit().getRate() + "\t" +
                                oneBankOneCredit.getAbstractCredit().getCreditTerm());

                    } catch (BankException e) {
                        throw new RuntimeException(e);
                    }
                });



            });


            mainMenu.putAction("quit", () -> System.exit(0));
            mainMenu.activateMenu();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}



