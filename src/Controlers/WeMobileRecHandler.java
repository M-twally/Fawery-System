package Controlers;
import java.util.ArrayList;

public class WeMobileRecHandler implements Ihandler  {
	 ArrayList<String> Data = new ArrayList<String>();
	 public WeMobileRecHandler(ArrayList<String> data) {
		 Data=data;
	}

	@Override
	public boolean Handler() {
		boolean check=true;
		if(Data.get(0).length()==11) {
		   if(Data.get(0).charAt(0)=='0'&&Data.get(0).charAt(1)=='1'&&Data.get(0).charAt(2)=='5') {
			   check=true;
		   }else {
			   check=false;
		   }
		}else {
			check=false;
		}
		int amount=Integer.parseInt(Data.get(1));
		if(!(amount>=100&&amount<=300)) {
			check=false;
		}
	    return check;
	}

}
