package com.company.IdeaProjects.FawryService.Controlers;
import java.util.ArrayList;

public class WeMobileForm extends Iform{

	@Override
	public ArrayList<String> createForm() {
		String Phone="Enter your Mobile number";
		String Amount="Enter your Amount from 100 to 300:";
		data.add(Phone);
		data.add(Amount);
		return data;
	}

}
