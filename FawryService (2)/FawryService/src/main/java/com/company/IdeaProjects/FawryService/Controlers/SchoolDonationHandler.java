package com.company.IdeaProjects.FawryService.Controlers;

import java.util.ArrayList;

public class SchoolDonationHandler extends Ihandler
{
    @Override
    public String Handler(ArrayList<String> Data) {
        for(int i=0;i<Data.get(0).length();i++){
            if(Data.get(0).length()!=11){
                return "YOUR NUMBER DIGIT MUST BE 11";
            }
            if(Character.isLetter(Data.get(0).charAt(i))){
                return "YOUR NUMBER SHOULD NOT HAVE CHARACTERS";
            }

        }
        for(int i=0;i<Data.get(2).length();i++){
            if(Data.get(2).length()!=5){
                return "THE ZIP CODE SHOULD BE 5 DIGITS !";
            }
            if(Character.isLetter(Data.get(2).charAt(i))){
                return "THE ZIP CODE SHOULD NOT HAVE CHARACTERS";
            }

        }
        int amount=Integer.parseInt(Data.get(3));
        if(!(amount>=1&&amount<=10000)) {
            return "YOUR AMOUNT RANGE SHOULD BE FROM 1-10000";
        }
        return "YOUR DATA IS CORRECT,PLEASE PROCEED TO PAYMENT";
    }
}
