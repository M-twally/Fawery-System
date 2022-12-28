package com.company.IdeaProjects.FawryService.Controlers;
import com.company.IdeaProjects.FawryService.Bsl.UserBSl;
import com.company.IdeaProjects.FawryService.Bsl.ServicesBSL;
import com.company.IdeaProjects.FawryService.Models.databaseEntity;
import com.company.IdeaProjects.FawryService.Models.servicesType;
import com.company.IdeaProjects.FawryService.Models.transaction;
import com.company.IdeaProjects.FawryService.Models.user;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
@RestController
public class userCTRL {
      databaseEntity entity =databaseEntity.getInstance();
      UserBSl userBSl =new UserBSl();
      ServicesBSL servicesBsl =new ServicesBSL();
      @PostMapping(value = "/signupuser")
      public String Signup(@RequestBody user user){
          return userBSl.SignUP(user);
      }
      @PostMapping(value = "/signinuser")
      public String SignInCTRL(@RequestBody user user){
        return userBSl.signIn(user);
      }
      @GetMapping(value = "/searchForServices/{serviceInput}")
      public ArrayList<String> searchMatchingServices(@PathVariable ("serviceInput") String serviceInput){
          return servicesBsl.Search(serviceInput);
      }

      public user  getUser(){
          return entity.getCurrentUser();
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
//      public void callForm(factoryServiceProvider service,String typeOfService,String provider) {
//          service.orderForm(typeOfService, provider);
//      }

      public void setTransaction(transaction t  , int amount , String TransactionType, String TransactionService){
          t.setAmountOfTrans(amount);
          t.setTransactionType("pay");
          t.setTransactionServiceType("Mobile recharge services");
      }
//      public float payTransaction(iPayment payment, transaction t ){
//          t.setAmountOfTrans(payment.pay(t));
//          return payment.pay(t);
//      }


}
