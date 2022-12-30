package com.company.IdeaProjects.FawryService.Controlers;

import java.util.ArrayList;

public class OrangeMobileHandler extends Ihandler{
    @Override
    public String Handler(ArrayList<String> Data) {
        for(int i=0;i<Data.get(0).length();i++){
            if(Data.get(0).length()!=11){
                return "YOUR NUMBER DIGIT MUST BE 11";
            }
            if(Character.isLetter(Data.get(0).charAt(i))){
                return "YOUR NUMBER SHOULD NOT HAVE CHARACTERS !";
            }
            if(Data.get(0).charAt(0)!='0'||Data.get(0).charAt(1)!='1'||Data.get(0).charAt(2)!='2') {
                return  "YOUR NUMBER SHOULD START WITH 012";
            }

        }
        int amount=Integer.parseInt(Data.get(1));
        if(!(amount>=50&&amount<=300)) {
            return "YOUR AMOUNT RANGE SHOULD BE FROM 50-300";
        }
        return "YOUR DATA IS CORRECT";
    }
}
