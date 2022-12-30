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
    @GetMapping(value = "/choiceForm/{id}")
    public ArrayList<String> choiceService(@PathVariable ("id")int id){
        return servicesBsl.getForm(id);
    }
    @PostMapping(value = "/formInput")
    public String EnterFormData(@RequestBody ArrayList<String> dataForm){
        return servicesBsl.CompleteForm(dataForm);
    }

    @PostMapping(value = "/AddToWallet")
    String updateOverallDiscount(@RequestBody String amount){
        return   userBSl.addWallet(amount);

    }
    @GetMapping(value = "/showYourData")
    public user addToWallet(){
        return userBSl.ShowCurrentUserData();
    }
    @GetMapping(value = "/PaymentMethod")
    public HashMap<Integer, String> ShowWayOfPayment(){
        return entity.getPaymentType();
    }
    @GetMapping(value = "/PaymentMethod/{ID}")
    public ArrayList<String> Payment(@PathVariable ("ID")int id){
        return userBSl.PaymentMethod(id);
    }
    @GetMapping(value = "/ViewCurrentUserPaymentTransactions")
    public ArrayList<transaction> ShowPaymentTransactions(){
        return userBSl.ShowPaymentTransactions();
    }

    @PostMapping(value = "/MakeRefundRequest")
    String MakeRefundRequest(@RequestBody String amount){
        return   userBSl.MakeRefundRequest(amount);

    }


}
