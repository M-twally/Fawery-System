package com.company.IdeaProjects.FawryService.Controlers;

import java.util.ArrayList;

public class OrangeInternetHandler extends Ihandler {
    @Override
    public String Handler(ArrayList<String> Data) {
        if(Data.get(0).length()!=11){
            return "YOUR NUMBER DIGIT MUST BE 11";
        }
        if(Data.get(0).charAt(0)!='0'||Data.get(0).charAt(1)!='1'||Data.get(0).charAt(2)!='2') {
            return  "YOUR NUMBER SHOULD START WITH 012";
        }

        int amount=Integer.parseInt(Data.get(1));
        if(!(amount==7||amount==15||amount==30||amount==45)) {
            return "PLEASE CHOOSE A PACKAGE AMOUNT!";
        }
        return "YOUR DATA IS CORRECT";
    }
}
