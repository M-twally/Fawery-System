package com.company.IdeaProjects.FawryService.Controlers;

import java.util.ArrayList;

public class QuarterLandlineHandler extends Ihandler
{
    @Override
    public String Handler(ArrayList<String> Data) {
        for(int i=0;i<Data.get(0).length();i++){
            if(Data.get(0).length()!=10){
                return "YOUR NUMBER DIGIT MUST BE 10";
            }
            if(Character.isLetter(Data.get(0).charAt(i))){
                return "YOUR NUMBER SHOULD NOT HAVE CHARACTERS !";
            }
            if(Data.get(0).charAt(0)!='0'||Data.get(0).charAt(1)!='2') {
                return  "YOUR NUMBER SHOULD START WITH 02";
            }

        }
        int amount=Integer.parseInt(Data.get(1));
        if(!(amount>=500&&amount<=1000)) {
            return "YOUR AMOUNT RANGE SHOULD BE FROM 500-1000";
        }
        return "YOUR DATA IS CORRECT,PLEASE PROCEED TO PAYMENT";
    }
}