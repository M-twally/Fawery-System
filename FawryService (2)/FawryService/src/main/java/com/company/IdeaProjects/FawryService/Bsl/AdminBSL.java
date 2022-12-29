package com.company.IdeaProjects.FawryService.Bsl;

import com.company.IdeaProjects.FawryService.Models.databaseEntity;
import com.company.IdeaProjects.FawryService.Models.transaction;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

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
    public ArrayList<transaction> ShowUserTransaction(int UserID, int TransactionID){
        ArrayList<transaction>t=new ArrayList<>();
        for(int i=0;i<entity.getUserVector().size();i++){
            if(entity.getUserVector().get(i).getId()==UserID){
                for(int j=0;j<entity.getUserVector().get(i).getTransactionsVector().size();j++){
                    if(GETtansactionName(TransactionID)!=null){
                        String Tname=GETtansactionName(TransactionID);
                        if(Objects.equals(entity.getUserVector().get(i).getTransactionsVector().get(j).getTransactionType(), Tname)){
                            t.add(entity.getUserVector().get(i).getTransactionsVector().get(j));
                        }

                    }
                }
            }
        }
        return t;
    }
    private String GETtansactionName(int id){
        for (Map.Entry<Integer,String> entry : entity.getIDTransactions().entrySet()) {
            if (Objects.equals(id, entry.getKey())){
                return entry.getValue();
            }
        }
        return null;
    }


}
