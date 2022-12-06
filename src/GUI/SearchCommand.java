package GUI;
import DataCollocation.*;
import java.util.Scanner;
import Services.*;

public class SearchCommand implements iCommand {
    userCTRL ctrl =new userCTRL();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void executeRequest() {


        do {
            try {


                System.out.println("1-show all services ");//trans
                System.out.println("2-search for service");
                System.out.println("0-back");
                int request = Integer.parseInt(scanner.nextLine());
                if(request==0){
                    break;
                }else if (request == 1) {
                    while (true) {
                        System.out.println("1-for Mobile recharge services:");
                        System.out.println("2-for Internet Payment services:");
                        System.out.println("3-for Landline services");
                        System.out.println("4-for Donations:");
                        System.out.println("0-back");
                        int choice = Integer.parseInt(scanner.nextLine());
                        if(choice == 0 ){
                            break;
                        } else if (choice == 1) {
                            while (true){
                                System.out.println("1-We Mobile recharge services:");
                                System.out.println("2-Etisalat Mobile recharge services:");
                                System.out.println("3-Vodafon Mobile recharge services:");
                                System.out.println("4-Orange Mobile recharge services:");
                                System.out.println("0-back");
                                int choice0 = Integer.parseInt(scanner.nextLine());
                                if(choice0==1){
                                    factoryServiceProvider service = new we();
                                    ctrl.callForm(service,"Mobile Recharge","We");
                                    while (true){
                                        System.out.println("please choose A payment method ");//trans
                                        System.out.println("1-pay by cash ");//trans
                                        System.out.println("2-pay by creditcard");
                                        System.out.println("3-pay by wallet");
                                        System.out.println("0-back");
                                        int choice00 = Integer.parseInt(scanner.nextLine());
                                        if(choice00==1){
                                            iPayment payment =new CashPayment();
                                            paymentType(payment,"Mobile Recharge");
                                        }else if(choice00==2){
                                            iPayment payment =new creditCard();
                                            paymentType(payment,"Mobile Recharge");
                                        }else if(choice00==3){
                                            iPayment payment =new WalletPayment();
                                            paymentType(payment,"Mobile Recharge");
                                        }else if(choice00==0){
                                            break;
                                        }
                                    }
                                }else if(choice0==2){
                                    factoryServiceProvider service = new Etisalat();
                                    ctrl.callForm(service,"Mobile Recharge","Etisalat");
                                    while (true){
                                        System.out.println("please choose A payment method ");//trans
                                        System.out.println("1-pay by cash ");//trans
                                        System.out.println("2-pay by creditcard");
                                        System.out.println("3-pay by wallet");
                                        System.out.println("0-back");
                                        int choice00 = Integer.parseInt(scanner.nextLine());
                                        if(choice00==1){
                                            iPayment payment =new CashPayment();
                                            paymentType(payment,"Mobile Recharge");
                                        }else if(choice00==2){
                                            iPayment payment =new creditCard();
                                            paymentType(payment,"Mobile Recharge");
                                        }else if(choice00==3){
                                            iPayment payment =new WalletPayment();
                                            paymentType(payment,"Mobile Recharge");
                                        }else if(choice00==0){
                                            break;
                                        }
                                    }


                                }else if(choice0==3){
                                    factoryServiceProvider service = new Vodafone();
                                    ctrl.callForm(service,"Mobile Recharge","Vodafone");
                                    while(true){
                                        System.out.println("please choose A payment method ");//trans
                                        System.out.println("1-pay by cash ");//trans
                                        System.out.println("2-pay by creditcard");
                                        System.out.println("3-pay by wallet");
                                        System.out.println("0-back");
                                        int choice00 = Integer.parseInt(scanner.nextLine());
                                        if(choice00==1){
                                            iPayment payment =new CashPayment();
                                            paymentType(payment,"Mobile Recharge");
                                        }else if(choice00==2){
                                            iPayment payment =new creditCard();
                                            paymentType(payment,"Mobile Recharge");

                                        }else if(choice00==3){
                                            iPayment payment =new WalletPayment();
                                            paymentType(payment,"Mobile Recharge");

                                        }else if(choice00==0){
                                            break;
                                        }

                                    }

                                }else if(choice0==4){
                                    factoryServiceProvider service = new Orange();
                                    ctrl.callForm(service,"Mobile Recharge","Orange");
                                    while(true){
                                        System.out.println("please choose A payment method ");//trans
                                        System.out.println("1-pay by cash ");//trans
                                        System.out.println("2-pay by creditcard");
                                        System.out.println("3-pay by wallet");
                                        System.out.println("0-back");
                                        int choice00 = Integer.parseInt(scanner.nextLine());
                                        if(choice00==1){
                                            iPayment payment =new CashPayment();
                                            paymentType(payment,"Mobile Recharge");
                                        }else if(choice00==2){
                                            iPayment payment =new creditCard();
                                            paymentType(payment,"Mobile Recharge");

                                        }else if(choice00==3){
                                            iPayment payment =new WalletPayment();
                                            paymentType(payment,"Mobile Recharge");

                                        }else if(choice00==0){
                                            break;
                                        }

                                    }


                                }else if(choice0==0){
                                    break;
                                }
                            }
                        } else if (choice == 2) {
                            while (true){
                                System.out.println("1-We Internet Payment services :");
                                System.out.println("2-Etisalat Internet Payment services:");
                                System.out.println("3-Vodafone Internet Payment services:");
                                System.out.println("4-Orange Internet Payment services:");
                                System.out.println("0-back");
                                int choice0 = Integer.parseInt(scanner.nextLine());
                                if (choice0==1){
                                    factoryServiceProvider service = new we();
                                    ctrl.callForm(service,"Internet Payment services","We");
                                    while (true){
                                        System.out.println("please choose A payment method ");//trans
                                        System.out.println("1-pay by cash ");//trans
                                        System.out.println("2-pay by creditcard");
                                        System.out.println("3-pay by wallet");
                                        System.out.println("0-back");
                                        int choice00 = Integer.parseInt(scanner.nextLine());
                                        if (choice00==1){
                                            iPayment payment =new CashPayment();
                                            paymentType(payment,"Internet Payment");

                                        }else if(choice00==2){
                                            iPayment payment =new creditCard();
                                            paymentType(payment,"Internet Payment");
                                        }else if(choice00==3){
                                            iPayment payment =new WalletPayment();
                                            paymentType(payment,"Internet Payment");
                                        }else if(choice00==0){
                                            break;
                                        }
                                    }

                                }else if (choice0==2){
                                    factoryServiceProvider service = new Etisalat();
                                    ctrl.callForm(service,"Internet Payment services","Etisalat");
                                    while (true){
                                        System.out.println("please choose A payment method ");//trans
                                        System.out.println("1-pay by cash ");//trans
                                        System.out.println("2-pay by creditcard");
                                        System.out.println("3-pay by wallet");
                                        System.out.println("0-back");
                                        int choice00 = Integer.parseInt(scanner.nextLine());
                                        if (choice00==1){
                                            iPayment payment =new CashPayment();
                                            paymentType(payment,"Internet Payment");

                                        }else if(choice00==2){
                                            iPayment payment =new creditCard();
                                            paymentType(payment,"Internet Payment");
                                        }else if(choice00==3){
                                            iPayment payment =new WalletPayment();
                                            paymentType(payment,"Internet Payment");
                                        }else if(choice00==0){
                                            break;
                                        }
                                    }

                                }else if(choice0==3){
                                    factoryServiceProvider service = new Vodafone();
                                    ctrl.callForm(service,"Internet Payment services","Vodafone");
                                    while (true){
                                        System.out.println("please choose A payment method ");//trans
                                        System.out.println("1-pay by cash ");//trans
                                        System.out.println("2-pay by creditcard");
                                        System.out.println("3-pay by wallet");
                                        System.out.println("0-back");
                                        int choice00 = Integer.parseInt(scanner.nextLine());
                                        if (choice00==1){
                                            iPayment payment =new CashPayment();
                                            paymentType(payment,"Internet Payment");

                                        }else if(choice00==2){
                                            iPayment payment =new creditCard();
                                            paymentType(payment,"Internet Payment");
                                        }else if(choice00==3){
                                            iPayment payment =new WalletPayment();
                                            paymentType(payment,"Internet Payment");
                                        }else if(choice00==0){
                                            break;
                                        }
                                    }
                                }else if(choice0==4){
                                    factoryServiceProvider service = new Orange();
                                    ctrl.callForm(service,"Internet Payment services","Orange");
                                    while(true){
                                        System.out.println("please choose A payment method ");//trans
                                        System.out.println("1-pay by cash ");//trans
                                        System.out.println("2-pay by creditcard");
                                        System.out.println("3-pay by wallet");
                                        System.out.println("0-back");
                                        int choice00 = Integer.parseInt(scanner.nextLine());
                                        if(choice00==1){
                                            iPayment payment =new CashPayment();
                                            paymentType(payment,"Internet Payment");
                                        }else if(choice00==2){
                                            iPayment payment =new creditCard();
                                            paymentType(payment,"Internet Payment");

                                        }else if(choice00==3){
                                            iPayment payment =new WalletPayment();
                                            paymentType(payment,"Internet Payment");

                                        }else if(choice00==0){
                                            break;
                                        }

                                    }

                                }else if(choice0==0){
                                    break;
                                }
                            }
                        }else if(choice==3){
                            while (true){
                                System.out.println("1-Monthly Landline Receipt");
                                System.out.println("2-Quarter Landline Receipt");
                                System.out.println("0-back");
                                int choice0 = Integer.parseInt(scanner.nextLine());
                                if (choice0==1){
                                    factoryServiceProvider service = new LandlineMonthlyReceipt();
                                    ctrl.callForm(service,"Monthly Receipt","Landline Monthly Receipt");
                                    while(true){
                                        System.out.println("please choose A payment method ");//trans
                                        System.out.println("1-pay by cash ");//trans
                                        System.out.println("2-pay by creditcard");
                                        System.out.println("3-pay by wallet");
                                        System.out.println("0-back");
                                        int choice00 = Integer.parseInt(scanner.nextLine());
                                        if(choice00==1){
                                            iPayment payment =new CashPayment();
                                            paymentType(payment,"Landline Monthly Receipt");
                                        }else if(choice00==2){
                                            iPayment payment =new creditCard();
                                            paymentType(payment,"Landline Monthly Receipt");

                                        }else if(choice00==3){
                                            iPayment payment =new WalletPayment();
                                            paymentType(payment,"Landline Monthly Receipt");

                                        }else if(choice00==0){
                                            break;
                                        }

                                    }
                                }else if(choice0==2){
                                    factoryServiceProvider service = new LandlineQuarterReceipt();
                                    ctrl.callForm(service,"Quarter Receipt","Landline Quarter Receipt");
                                    while(true){
                                        System.out.println("please choose A payment method ");//trans
                                        System.out.println("1-pay by cash ");//trans
                                        System.out.println("2-pay by creditcard");
                                        System.out.println("3-pay by wallet");
                                        System.out.println("0-back");
                                        int choice00 = Integer.parseInt(scanner.nextLine());
                                        if(choice00==1){
                                            iPayment payment =new CashPayment();
                                            paymentType(payment,"Landline Quarter Receipt");
                                        }else if(choice00==2){
                                            iPayment payment =new creditCard();
                                            paymentType(payment,"Landline Quarter Receipt");

                                        }else if(choice00==3){
                                            iPayment payment =new WalletPayment();
                                            paymentType(payment,"Landline Quarter Receipt");

                                        }else if(choice00==0){
                                            break;
                                        }

                                    }
                                }else if (choice0==0){
                                    break;
                                }
                            }
                        }else if(choice==4){
                            while (true){
                                System.out.println("1-Cancer Hospital :");
                                System.out.println("2-Schools:");
                                System.out.println("3-Non Profitable Organization");
                                System.out.println("0-back");
                                int choice0 = Integer.parseInt(scanner.nextLine());
                                if (choice0==1){
                                    factoryServiceProvider service = new CancerHospital();
                                    ctrl.callForm(service,"Cancer Hospital","Cancer Hospital");
                                    while(true){
                                        System.out.println("please choose A payment method ");//trans
                                        System.out.println("1-pay by cash ");//trans
                                        System.out.println("2-pay by creditcard");
                                        System.out.println("3-pay by wallet");
                                        System.out.println("0-back");
                                        int choice00 = Integer.parseInt(scanner.nextLine());
                                        if(choice00==1){
                                            iPayment payment =new CashPayment();
                                            paymentType(payment,"Cancer Hospital Donations");
                                        }else if(choice00==2){
                                            iPayment payment =new creditCard();
                                            paymentType(payment,"Cancer Hospital Donations");

                                        }else if(choice00==3){
                                            iPayment payment =new WalletPayment();
                                            paymentType(payment,"Cancer Hospital Donations");

                                        }else if(choice00==0){
                                            break;
                                        }

                                    }

                                }else if(choice0==2){
                                    factoryServiceProvider service = new Schools();
                                    ctrl.callForm(service,"Schools Donations","Schools");
                                    while(true){
                                        System.out.println("please choose A payment method ");//trans
                                        System.out.println("1-pay by cash ");//trans
                                        System.out.println("2-pay by creditcard");
                                        System.out.println("3-pay by wallet");
                                        System.out.println("0-back");
                                        int choice00 = Integer.parseInt(scanner.nextLine());
                                        if(choice00==1){
                                            iPayment payment =new CashPayment();
                                            paymentType(payment,"Schools Donations");
                                        }else if(choice00==2){
                                            iPayment payment =new creditCard();
                                            paymentType(payment,"Schools Donations");

                                        }else if(choice00==3){
                                            iPayment payment =new WalletPayment();
                                            paymentType(payment,"Schools Donations");

                                        }else if(choice00==0){
                                            break;
                                        }

                                    }

                                }else if(choice0==3){
                                    factoryServiceProvider service = new NGOs();
                                    ctrl.callForm(service,"Non profitable organizations Donations","Non profitable organizations");
                                    while(true){
                                        System.out.println("please choose A payment method ");//trans
                                        System.out.println("1-pay by cash ");//trans
                                        System.out.println("2-pay by creditcard");
                                        System.out.println("3-pay by wallet");
                                        System.out.println("0-back");
                                        int choice00 = Integer.parseInt(scanner.nextLine());
                                        if(choice00==1){
                                            iPayment payment =new CashPayment();
                                            paymentType(payment,"Non profitable organizations Donations");
                                        }else if(choice00==2){
                                            iPayment payment =new creditCard();
                                            paymentType(payment,"Non profitable organizations Donations");

                                        }else if(choice00==3){
                                            iPayment payment =new WalletPayment();
                                            paymentType(payment,"Non profitable organizations Donations");

                                        }else if(choice00==0){
                                            break;
                                        }

                                    }

                                }

                            }
                        }
                    }

                } else if (request == 2) {
                    System.out.println("Enter service name:");
                    String serviceName = scanner.nextLine();
                }
            }catch (NumberFormatException e){
                System.out.println("you enter wrong data please try again");
            }
        }while (true);
    }
    public void paymentType( iPayment payment,String x){
        payment=new OverallDiscounts(payment);
        payment=new SpecificDiscount(payment);
        transaction t =new transaction();
        int amount = Integer.parseInt(scanner.nextLine());
        ctrl.setTransaction(t,amount,"pay",x);
        ctrl.getUser().getTransactionsVector().add(t);
        System.out.print("your total payment:");
        System.out.println(ctrl.payTransaction(payment,t));
    }
}
