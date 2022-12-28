package com.company.IdeaProjects.FawryService.Bsl;
import com.company.IdeaProjects.FawryService.Models.databaseEntity;
import com.company.IdeaProjects.FawryService.Models.servicesType;

import java.util.ArrayList;
import java.util.Locale;

public class ServicesBSL {
    databaseEntity entity =databaseEntity.getInstance();
    private boolean isMatching(String input,String Service){
        int firstChar=input.charAt(0);
        for(int i=0;i<Service.length();i++){
            if(Service.charAt(i)==firstChar){
                int z=i;
                int totalChar=0;
                for(int j=0;j<input.length()&&z<Service.length();j++){
                    if(input.charAt(j)==Service.charAt(z)){
                        totalChar++;
                    }else {
                        break;
                    }
                    z++;
                }
                if(totalChar==input.length()){
                    return true;
                }
            }

        }
        return false;
    }

    public ArrayList<String> Search(String serviceInput){
        String swap=serviceInput.toUpperCase();
        String result;
        ArrayList<String> listOfServices=new ArrayList<>();
        for(int i = entity.getServicesTypes().size() - 1; i >= 0; i--){
            if(isMatching(swap,entity.getServicesTypes().get(i).getName())){
                result="ID:"+entity.getServicesTypes().get(i).getId()+" & "+"NAME:"+entity.getServicesTypes().get(i).getName();
                listOfServices.add(result);
            }
        }
        return listOfServices;
    }
    public ArrayList<String> getForm(int id){
        ArrayList<String> form=new ArrayList<>();
        for(int i=0;i<entity.getServicesTypes().size();i++){
            if(entity.getServicesTypes().get(i).getId()==id){
                return entity.getServicesTypes().get(i).getIform().createForm();
            }

        }

        return null;
    }
    public String checkHandler(int id,ArrayList<String> dataForm){
        for(int i=0;i<entity.getServicesTypes().size();i++){
            if(entity.getServicesTypes().get(i).getId()==id){
                return  entity.getServicesTypes().get(i).getIhandler().Handler(dataForm);
            }
        }
        return null;
    }
}
