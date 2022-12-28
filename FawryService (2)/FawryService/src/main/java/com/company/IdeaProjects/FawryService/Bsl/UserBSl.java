package com.company.IdeaProjects.FawryService.Bsl;
import com.company.IdeaProjects.FawryService.Models.databaseEntity;
import com.company.IdeaProjects.FawryService.Models.user;

import java.util.Objects;

public class UserBSl {
    databaseEntity entity =databaseEntity.getInstance();
    public String SignUP(user user){
        for(int i=0;i<entity.getUserVector().size();i++){
            if(Objects.equals(entity.getUserVector().get(i).getEmail(), user.getEmail())){
                return "THIS USER ALREADY EXIST!";
            }
        }
        entity.getUserVector().add(user);
        return "SIGNUP SUCCESSFULLY !";
    }
    public String signIn(user user){
        for (int i=0;i<entity.getUserVector().size();i++) {
            if (Objects.equals(entity.getUserVector().get(i).getEmail(), user.getEmail()) && Objects.equals(entity.getUserVector().get(i).getPassword(), user.getPassword())) {
                entity.setCurrentUser(entity.getUserVector().get(i));
                return "WELCOME BACK!";
            }
        }
        return "PLEASE SIGN UP FIRST!";
    }
    public String addWallet(float amount){
        if(entity.getCurrentUser()==null){
            return "YOU SHOULD SIGNIN FIRST!";
        }else {
            entity.saveToWallet(amount);
        }
        return "ADDING amount:"+amount+" SUCCESSFUL YOUR WALLET BALANCE:"+entity.getCurrentUser().getWalletBalance();
    }
    public user ShowCurrentUserData(){
        if(entity.getCurrentUser()!=null){
            return entity.getCurrentUser();
        }
        return null;
    }



}
