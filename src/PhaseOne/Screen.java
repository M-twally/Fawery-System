package PhaseOne;

import java.util.Scanner;

public class Screen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        userCTRL ctrl =new userCTRL();
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
                while (true) {
                    if (choice == 2) {
                        System.out.println("to signIn enter 1:");
                        System.out.println("to signUp enter 2:");
                        System.out.println("back press 0");
                        int sign = Integer.parseInt(scanner.nextLine());
                        if(sign==0){
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
                                if (ctrl.signUp(username, email, password)) {
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
                                if (ctrl.signIN(email, password)) {
                                    ctrl.ShowUserData(email,password);
                                    //user found in my system show his data and services
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
