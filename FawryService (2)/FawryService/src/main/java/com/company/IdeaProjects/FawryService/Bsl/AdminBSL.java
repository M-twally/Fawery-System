package com.company.IdeaProjects.FawryService.Bsl;

import com.company.IdeaProjects.FawryService.Models.databaseEntity;

import java.util.ArrayList;

public class AdminBSL {
    databaseEntity entity =databaseEntity.getInstance();
    public ArrayList<String> getAllUsersData(){
        String data;
        ArrayList<String> UsersData=new ArrayList<>();
        for(int i=0;i<entity.getUserVector().size();i++){
            data = "ID:"+entity.getUserVector().get(i).getId()+" ,UserName:"+entity.getUserVector().get(i).getUserName()+" ,Email:"+entity.getUserVector().get(i).getEmail();
            UsersData.add(data);
        }
        return UsersData;
    }


}
