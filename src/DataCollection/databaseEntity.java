package DataCollection;

import java.util.Objects;
import java.util.Vector;
import java.util.HashMap;
public class databaseEntity {
       Vector<user>userVector=new Vector<>();
       private static HashMap<String,Integer> discounts = new HashMap<String,Integer>();
       private static databaseEntity entity =null;
       private  user currentUser=null;
       private float OverallDiscount=0;

       public Vector<user> getUserVector() {
              return userVector;
       }

       public static databaseEntity getInstance(){
              if(entity==null){
                     entity=new databaseEntity();
                     discounts.put("Mobile recharge services",0);
                     discounts.put("Internet Payment services",0);
                     discounts.put("Landline services",0);
                     discounts.put("Donations",0);
                                   }
              return entity;
       }

       public void getUsers(){
              for (DataCollection.user user : userVector) {
                     System.out.println(user.userName);
                     System.out.println(user.email);
                     user.getUserTransactions();
              }
       }
       public boolean checkingUserExist(String email){
              for (DataCollection.user user : userVector) {
                     if (Objects.equals(user.email, email)) {
                            return true;
                     }
              }
              return false;
       }

       public boolean checkingUserData(String email,String password){
              for (DataCollection.user user : userVector) {
                     if (Objects.equals(user.email, email) && Objects.equals(user.Password, password)) {
                            setCurrentUser(user);
                            return true;
                     }
              }
              return false;
       }
       public void getUserData(String email,String password){
              for (DataCollection.user user : userVector) {
                     if (Objects.equals(user.email, email) && Objects.equals(user.Password, password)) {
                            System.out.println("UserName:"+user.userName);
                            System.out.println("email:"+user.email);
                            System.out.println("wallet:"+user.walletBalance);
                            break;
                     }
              }
       }

       public user getCurrentUser() {
              return currentUser;
       }

       public void setCurrentUser(user currentUser) {
              this.currentUser = currentUser;
       }
       public void saveToWallet(float amount){
              getCurrentUser().walletBalance=amount;
       }
       public HashMap<String, Integer> getDiscounts() {
              return discounts;
       }



       public void setSpecificDiscount(String name, int amount){
              discounts.put(name,amount);
       }

       public float getOverallDiscount() {
              return OverallDiscount;
       }

       public void setOverallDiscount(int overallDiscount) {
              OverallDiscount = overallDiscount;
       }

       public void setUserVector(Vector<user> userVector) {
              this.userVector = userVector;
       }
}
