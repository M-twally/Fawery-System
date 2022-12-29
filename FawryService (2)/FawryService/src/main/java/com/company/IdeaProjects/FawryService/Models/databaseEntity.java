package com.company.IdeaProjects.FawryService.Models;

import com.company.IdeaProjects.FawryService.Controlers.VodafoneMobileForm;
import com.company.IdeaProjects.FawryService.Controlers.VodafoneMobileHandler;
import com.company.IdeaProjects.FawryService.Controlers.WeMobileForm;
import com.company.IdeaProjects.FawryService.Controlers.WeMobileHandler;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;

public class databaseEntity {
       Vector<user>userVector=new Vector<>();
       private static HashMap<Integer,String> PaymentType = new HashMap<Integer,String>();
       private static HashMap<Integer,String> IDTransactions = new HashMap<Integer,String>();
       private static HashMap<Integer, Pair<String,Float>> SpecificDiscount = new HashMap<Integer,Pair<String,Float>>();
       private static databaseEntity entity =null;
       private  user currentUser=null;
       private float OverallDiscount=0;
       private static   Vector<servicesType> servicesTypes=new Vector<>();
       private static Pair<String,Float> P1=new Pair<>("MOBILE RECHARGE",0.0F);
       private static Pair<String,Float> P2=new Pair<>("Internet Payment",0.0F);
       private static Pair<String,Float> P3=new Pair<>("Landline services",0.0F);
       private static Pair<String,Float> P4=new Pair<>("Donations",0.0F);


       public static databaseEntity getInstance(){
              if(entity==null){
                     entity=new databaseEntity();
                     SpecificDiscount.put(1,P1);
                     SpecificDiscount.put(2,P2);
                     SpecificDiscount.put(3,P3);
                     SpecificDiscount.put(4,P4);
                     PaymentType.put(1,"Via CreditCard");
                     PaymentType.put(2,"CashPayment");
                     PaymentType.put(3,"WalletPayment");
                     IDTransactions.put(1,"Payment transaction");
                     IDTransactions.put(2,"Add to wallet transaction");
                     IDTransactions.put(3,"Refund transaction");
                     servicesTypes.add(new servicesType("WE MOBILE RECHARGE",new WeMobileForm(),new WeMobileHandler()));
                     servicesTypes.add(new servicesType("VODAFONE MOBILE RECHARGE",new VodafoneMobileForm(),new VodafoneMobileHandler()));
              }
              return entity;
       }
       public void setCurrentUser(user currentUser) {
              this.currentUser = currentUser;
       }
       public void setOverallDiscount(float overallDiscount) {

              OverallDiscount = overallDiscount;
       }

       public Vector<user> getUserVector() {
              return userVector;
       }
       public void getUsers(){
              for (com.company.IdeaProjects.FawryService.Models.user user : userVector) {
                     System.out.println(user.userName);
                     System.out.println(user.email);
//                     user.getUserTransactions();
              }
       }
       public user getCurrentUser() {
              for (int i=0;i<entity.getUserVector().size();i++) {
                     if (Objects.equals(getUserVector().get(i).getEmail(), currentUser.getEmail()) && Objects.equals(getUserVector().get(i).getPassword(),currentUser.getPassword())) {
                            currentUser=getUserVector().get(i);
                     }
              }
              return currentUser;
       }
       public float getOverallDiscount() {
              return OverallDiscount;
       }


       public  Vector<servicesType> getServicesTypes() {
              return servicesTypes;
       }
       public void saveToWallet(float amount){
              float wallet=amount+ getCurrentUser().getWalletBalance();
              getCurrentUser().setWalletBalance(wallet);
       }

       public  HashMap<Integer, String> getPaymentType() {
              return PaymentType;
       }

       public  HashMap<Integer, String> getIDTransactions() {
              return IDTransactions;
       }

       public HashMap<Integer, Pair<String,Float>> getIDSpecificDiscount() {
              return SpecificDiscount;
       }
}
