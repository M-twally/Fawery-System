package GUI;
import DataCollection.*;
import java.util.Scanner;

public class Screen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        userCTRL Uctrl =new userCTRL();
        adminCTRL Actrl=new adminCTRL();
        int choice;
        do{
            try {
                System.out.println("   welcome to system similar to Fawry");
                System.out.println("Continue as admin press 1:");
                System.out.println("Continue as user press 2:");
                System.out.println("Exit press 0:");
                choice = Integer.parseInt(scanner.nextLine());
                if(choice == 0){
                    return;
                }
                if(choice==1) {
                    while (true) {
                        System.out.println("1-Add new discount:");
                        System.out.println("2-Show all transaction:");
                        System.out.println("3-Show Refund");
                        System.out.println("0-back");
                        int adminSign = Integer.parseInt(scanner.nextLine());;
                        if (adminSign == 0) {
                            break;
                        }else if(adminSign==1){
                            System.out.println("1-ForOverall discounts:");
                            System.out.println("2-Specific discount:");
                            int disChoice = Integer.parseInt(scanner.nextLine());
                            if(disChoice==1){
                                System.out.println("Enter your amount:");
                                int disAmount = Integer.parseInt(scanner.nextLine());
                                Actrl.updateOverallDiscount(disAmount);
                            }else if(disChoice==2) {
                                System.out.println("1-for Mobile recharge services:");
                                System.out.println("2-for Internet Payment services:");
                                System.out.println("3-for Landline services");
                                System.out.println("4-for Donations:");
                                int disChoice0 = Integer.parseInt(scanner.nextLine());
                                System.out.print("Enter your amount:");
                                int disAmount = Integer.parseInt(scanner.nextLine());
                                if(disChoice0==1){
                                    Actrl.updateSpecificDiscount("Mobile recharge services",disAmount);
                                }else if(disChoice0==2){
                                    Actrl.updateSpecificDiscount("Internet Payment services",disAmount);
                                }else if(disChoice0==3){
                                    Actrl.updateSpecificDiscount("Landline services",disAmount);
                                }else if(disChoice0==4){
                                    Actrl.updateSpecificDiscount("Donations",disAmount);
                                }
                            }
                        }else if(adminSign == 2){
                            Actrl.showAllUser();
                        }
                    }
                }
                if(choice==2) {
                    while (true) {
                            System.out.println("to signIn enter 1:");
                            System.out.println("to signUp enter 2:");
                            System.out.println("back press 0");
                            int sign = Integer.parseInt(scanner.nextLine());
                            if (sign == 0) {
                                break;
                            }
                            while (true) {
                                if (sign == 2) {
                                    System.out.print("enter your username:");
                                    String username = scanner.nextLine();
                                    System.out.print("enter your email:");
                                    String email = scanner.nextLine();
                                    System.out.print("enter your password:");
                                    String password = scanner.nextLine();
                                    if (Uctrl.signUp(username, email, password)) {
                                        System.out.println("This account is exist please signIn or try again.");
                                    } else {
                                        System.out.println("  signUp successful now you can signIn");
                                    }
                                    break;
                                } else if (sign == 1) {
                                    System.out.print("enter your email:");
                                    String email = scanner.nextLine();
                                    System.out.print("enter your password:");
                                    String password = scanner.nextLine();
                                    if (Uctrl.signIN(email, password)) {
                                        //user found in my system show his data and services
                                        while (true) {
                                            System.out.println("1-payment for services");//show //search form check pay -
                                            System.out.println("2-add to wallet");
                                            System.out.println("3-show discounts");
                                            System.out.println("4-Refund transaction services");//trans
                                            System.out.println("0-back");
                                            int request = Integer.parseInt(scanner.nextLine());
                                            InvokerRequestCtrl invoker = new InvokerRequestCtrl();

                                            if (request == 1) {
                                                invoker.setCommand(new SearchCommand());
                                                invoker.doExecute();
                                            }
                                            else if (request == 2) {
                                                invoker.setCommand(new WalledCommand());
                                                invoker.doExecute();
                                                Uctrl.ShowUserData(email, password);
                                            }else if(request==3){
                                                System.out.print("Special Discounts:");
                                                System.out.println(Uctrl.showSpecialDiscounts());
                                                System.out.print("Over all Discounts:");
                                                System.out.println(Uctrl.ShowOverallDiscount());
                                                System.out.println();
                                            }else if(request==4){

                                            }
                                            if (request == 0) {
                                                break;
                                            }
                                        }
                                        break;

                                    } else {
                                        System.out.println(" user not exist please signUp or try again.");
                                        break;
                                    }
                                }
                            }

                    }
                }
            }catch (NumberFormatException e) {
                System.out.println("you enter wrong data please try again");
            }



        }while (true);

    }
}
