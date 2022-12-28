package com.company.IdeaProjects.FawryService.Models;

import com.company.IdeaProjects.FawryService.Controlers.VodafoneMobileForm;
import com.company.IdeaProjects.FawryService.Controlers.VodafoneMobileHandler;
import com.company.IdeaProjects.FawryService.Controlers.WeMobileForm;
import com.company.IdeaProjects.FawryService.Controlers.WeMobileHandler;

import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;

public class databaseEntity {
       Vector<user>userVector=new Vector<>();
       private static HashMap<String,Integer> discounts = new HashMap<String,Integer>();
       private static databaseEntity entity =null;
       private  user currentUser=null;
       private float OverallDiscount=0;
       private static   Vector<servicesType> servicesTypes=new Vector<>();


       public static databaseEntity getInstance(){
              if(entity==null){
                     entity=new databaseEntity();
                     discounts.put("Mobile recharge services",0);
                     discounts.put("Internet Payment services",0);
                     discounts.put("Landline services",0);
                     discounts.put("Donations",0);
                     servicesTypes.add(new servicesType("WE MOBILE RECHARGE",new WeMobileForm(),new WeMobileHandler()));
                     servicesTypes.add(new servicesType("VODAFONE MOBILE RECHARGE",new VodafoneMobileForm(),new VodafoneMobileHandler()));
              }
              return entity;
       }
       public void setCurrentUser(user currentUser) {
              this.currentUser = currentUser;
       }
       public void setSpecificDiscount(String name, int amount){
              discounts.put(name,amount);
       }
       public void setOverallDiscount(int overallDiscount) {
              OverallDiscount = overallDiscount;
       }
       public void setUserVector(Vector<user> userVector) {
              this.userVector = userVector;
       }

       public Vector<user> getUserVector() {
              return userVector;
       }
       public void getUsers(){
              for (com.company.IdeaProjects.FawryService.Models.user user : userVector) {
                     System.out.println(user.userName);
                     System.out.println(user.email);
                     user.getUserTransactions();
              }
       }
       public void getUserData(String email,String password){
              for (com.company.IdeaProjects.FawryService.Models.user user : userVector) {
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


       public float getOverallDiscount() {
              return OverallDiscount;
       }


       public HashMap<String, Integer> getDiscounts() {
              return discounts;
       }
       public  Vector<servicesType> getServicesTypes() {
              return servicesTypes;
       }
       public void saveToWallet(float amount){
              getCurrentUser().walletBalance=amount;
       }
}
