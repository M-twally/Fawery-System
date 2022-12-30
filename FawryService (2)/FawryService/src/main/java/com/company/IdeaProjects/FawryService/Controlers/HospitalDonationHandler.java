package com.company.IdeaProjects.FawryService.Controlers;

import java.util.ArrayList;

public class HospitalDonationHandler extends Ihandler
{
    @Override
    public String Handler(ArrayList<String> Data) {
        if(Data.get(0).length()!=11){
            return "YOUR NUMBER DIGIT MUST BE 11";
        }
        if(Data.get(2).length()!=5){
            return "THE ZIP CODE SHOULD BE 5 DIGITS !";
        }
        int amount=Integer.parseInt(Data.get(3));
        if(!(amount>=1&&amount<=10000)) {
            return "YOUR AMOUNT RANGE SHOULD BE FROM 1-10000";
        }
        return "YOUR DATA IS CORRECT,PLEASE PROCEED TO PAYMENT";
    }
}
