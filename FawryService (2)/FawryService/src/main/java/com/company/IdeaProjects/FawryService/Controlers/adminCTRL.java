package com.company.IdeaProjects.FawryService.Controlers;
import com.company.IdeaProjects.FawryService.Models.databaseEntity;


public class adminCTRL {
    databaseEntity entity =databaseEntity.getInstance();
    public void updateOverallDiscount(int amount){
        entity.setOverallDiscount(amount);
    }
    public void updateSpecificDiscount(String name,int amount){
        entity.setSpecificDiscount(name, amount);
    }
    public void showAllUser(){

        entity.getUsers();
    }
}