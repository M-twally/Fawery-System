package GUI;
import PhaseOne.userCTRL;

import java.util.Scanner;

public class WalledCommand implements iCommand {
    @Override
    public void executeRequest() {
        userCTRL ctrl =new userCTRL();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your amount to add:");
        float amount = Float.parseFloat(scanner.nextLine());
        ctrl.addWallet(amount);
    }
}
