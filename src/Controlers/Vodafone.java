package Controlers;

import java.util.ArrayList;

public class Vodafone implements IservicesProvider  {

	@Override
	public Iform Createform(int type) {
		if(type==1) {
    		return new VodafoneMobileRecharge();
    	}
		return null;
	}

	@Override
	public Ihandler CreateHandler(int type, ArrayList<String> Data) {
		if(type==1) {
			return new VodafoneMobileRecHandler(Data);
		}
		return null;
	}

}
