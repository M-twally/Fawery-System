package com.company.IdeaProjects.FawryService.Controlers;
import java.util.ArrayList;

public class WeMobileHandler extends Ihandler  {

	@Override
	public String Handler(ArrayList<String> Data) {

		if(Data.get(0).length()!=11){
			return "YOUR NUMBER DIGIT MUST BE 11";
		}
		if(Data.get(0).charAt(0)!='0'||Data.get(0).charAt(1)!='1'||Data.get(0).charAt(2)!='5') {
			return  "YOUR NUMBER SHOULD START WITH 015";
		}

		int amount=Integer.parseInt(Data.get(1));
		if(!(amount>=100&&amount<=300)) {
			return "YOUR AMOUNT RANGE SHOULD BE FROM 100-300";
		}
		return "YOUR DATA IS CORRECT";
	}

}
