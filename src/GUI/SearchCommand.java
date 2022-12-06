package GUI;
import PhaseOne.*;
import java.util.Scanner;
import Services.*;

public class SearchCommand implements iCommand {
    userCTRL ctrl =new userCTRL();
    @Override
    public void executeRequest() {
        do {
            try {


                Scanner scanner = new Scanner(System.in);
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
                                  iPayment payment =new CashPayment();
                                  payment=new OverallDiscounts(payment);
                                  payment=new SpecificDiscount(payment);
                                  transaction t =new transaction();
                                  int amount = Integer.parseInt(scanner.nextLine());
                                  ctrl.setTransaction(t,amount,"pay","Mobile recharge services");
                                  ctrl.getUser().getTransactionsVector().add(t);
                                  System.out.print("your total payment:");
                                  System.out.println(ctrl.payTransaction(payment,t));
                                  break;
                              }else if(choice0==2){

                              }else if(choice0==3){

                              }
                          }
                      } else if (choice == 2) {

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
}
