package PhaseOne;

import java.util.Scanner;

public class Screen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        registrationCTRL ctrl =new registrationCTRL();
        int choice;
        do{
            try {
                System.out.println(" welcome to system similar to Fawry");
                System.out.println("Continue as admin press 1");
                System.out.println("Continue as user press 2");
                choice = Integer.parseInt(scanner.nextLine());
                if(choice==2){

                    System.out.println("enter your username:");
                    String username = scanner.nextLine();
                    System.out.println("enter your email");
                    String email = scanner.nextLine();
                    System.out.println("enter your password");
                    String password = scanner.nextLine();
                    ctrl.signUp(username,email,password);
                }

            }catch (NumberFormatException e) {
                System.out.println("you enter wrong data please try again");
            }



        }while (true);

    }
}
