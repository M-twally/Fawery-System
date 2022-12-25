package Controlers;
import java.util.ArrayList;

public class WeMobileRecharge implements Iform{
	ArrayList<String> Data = new ArrayList<String>();

	@Override
	public ArrayList<String> createForm() {
		String Phone="Enter your Mobile number";
		String Amount="Enter your Amount from 100 to 300:";
		Data.add(Phone);
		Data.add(Amount);
		return Data;
	}

}
