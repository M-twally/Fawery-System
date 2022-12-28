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
                    if(input.charAt(j)==Service.charAt(j)){
                        totalChar++;
                    }else {
                        break;
                    }
                    z++;
                }
                if(totalChar==input.length()){
                    System.out.println("koko");
                    return true;
                }
            }

        }
        return false;
    }

    public ArrayList<servicesType> Search(String serviceInput){
        serviceInput.toUpperCase(Locale.ROOT);
        ArrayList<servicesType> listOfServices=new ArrayList<>();
        System.out.println("dsa");
        for(int i=0;i<entity.getServicesTypes().size();i++){
            if(isMatching(serviceInput,entity.getServicesTypes().get(i).getName())){
                System.out.println("lolo");
                listOfServices.add(entity.getServicesTypes().get(i));
            }
        }
        return listOfServices;
    }
}
