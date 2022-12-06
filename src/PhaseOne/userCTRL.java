package PhaseOne;
import Services.*;

import java.util.HashMap;

public class userCTRL {
      databaseEntity entity =databaseEntity.getInstance();
      public boolean signUp(String userName, String email, String password){
           user user =new user(userName, email,password);
           if(entity.checkingUserExist(email)){
//               System.out.println("user exist please signIn");
               return true;
           }else {
               entity.userVector.add(user);
               return false;
           }
      }

      public user  getUser(){
          return entity.getCurrentUser();
      }
      public boolean signIN(String email,String password){
          if(entity.checkingUserData(email,password)){
              return true;
          }
          return false;
      }
      public void ShowUserData(String email,String password) {
    	  entity.getUserData(email, password);
      }

      public void addWallet(float amount){
        entity.saveToWallet(amount);
      }
      
      public HashMap<String, Integer> showSpecialDiscounts(){
          return entity.getDiscounts();
      }
      public float ShowOverallDiscount(){
          return entity.getOverallDiscount();
      }
      public void callForm(factoryServiceProvider service,String typeOfService,String provider) {
          service.orderForm(typeOfService, provider);
      }
      
      public void setTransaction( transaction t  ,int amount ,String TransactionType,String TransactionService){
          t.setAmountOfTrans(amount);
          t.setTransactionType("pay");
          t.setTransactionServiceType("Mobile recharge services");
      }
      public float payTransaction(iPayment payment,transaction t ){
          t.amountOfTrans=payment.pay(t);
          return payment.pay(t);
      }


}
