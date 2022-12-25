package Controlers;

import java.util.ArrayList;

public class We implements IservicesProvider {

	@Override
	public Iform Createform(int type) {
		if(type==1) {
    		return new WeMobileRecharge();
    	}
		return null;
	}

	@Override
	public Ihandler CreateHandler(int type, ArrayList<String> Data) {
		if(type==1) {
			return new WeMobileRecHandler(Data);
		}
		return null;
	}

}
