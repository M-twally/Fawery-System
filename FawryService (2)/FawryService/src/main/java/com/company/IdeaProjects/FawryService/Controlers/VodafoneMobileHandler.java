package com.company.IdeaProjects.FawryService.Controlers;

import java.util.ArrayList;

public class VodafoneMobileHandler extends Ihandler {
	 public VodafoneMobileHandler(ArrayList<String> data) {
		 super(data);

	 }

	@Override
	public boolean Handler() {
		boolean check;
		if(Data.get(0).length()==11&&Data.get(0).charAt(0)=='0'&&Data.get(0).charAt(1)=='1'&&Data.get(0).charAt(2)=='0') {
			check=true;
		}else {
			check=false;}
		int amount=Integer.parseInt(Data.get(1));
		if(!(amount>=100&&amount<=500)) {
			check=false;
		}
		return check;
	
	}

}
