package com.company.IdeaProjects.FawryService.Controlers;
import com.company.IdeaProjects.FawryService.Models.databaseEntity;
import com.company.IdeaProjects.FawryService.Bsl.AdminBSL;
import com.company.IdeaProjects.FawryService.Models.transaction;
import com.company.IdeaProjects.FawryService.Models.user;
import javafx.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class adminCTRL {
    databaseEntity entity =databaseEntity.getInstance();
    AdminBSL adminBSL =new AdminBSL();

    @PostMapping(value = "/AddOverallDiscount")
    String updateOverallDiscount(@RequestBody float amount){
        entity.setOverallDiscount(amount);
        return "ADDING SUCCESSFULLY";
    }
    @GetMapping(value = "/TransactionsTypes")
    public HashMap<Integer, String> ShowWayOfPayment(){
        return entity.getIDTransactions();
    }

    @GetMapping(value = "/UsersData")
    public ArrayList<String> ShowAllUsersID(){
        return adminBSL.getAllUsersData();
    }
    @GetMapping(value = "/listAllUserTransactions/{UserID}/{TransactionID}")
    public  ArrayList<transaction>  listAllUserTransactions(@PathVariable("UserID")int userId , @PathVariable ("TransactionID") int TransactionID){
        return adminBSL.ShowUserTransaction(userId,TransactionID);
    }


    @GetMapping(value = "/listOfSpecificDiscountWithID")
    public  HashMap<Integer, Pair<String,Float>>listOfSpecificDiscount(){
        return entity.getIDSpecificDiscount();
    }
}
