package com.company.IdeaProjects.FawryService.Controlers;
import com.company.IdeaProjects.FawryService.Models.databaseEntity;
import com.company.IdeaProjects.FawryService.Models.user;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class adminCTRL {
    databaseEntity entity =databaseEntity.getInstance();

    @PostMapping(value = "/AddOverallDiscount")
    String updateOverallDiscount(@RequestBody float amount){
        entity.setOverallDiscount(amount);
        return "ADDING SUCESSEFULY";
    }


    //    public void updateOverallDiscount(int amount){
//        entity.setOverallDiscount(amount);
//    }
    public void updateSpecificDiscount(String name,int amount){
        entity.setSpecificDiscount(name, amount);
    }
    public void showAllUser(){
        entity.getUsers();
    }
}
