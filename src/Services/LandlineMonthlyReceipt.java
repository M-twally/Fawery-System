package Services;

public class LandlineMonthlyReceipt extends factoryServiceProvider {

	@Override
	protected serviceProduct createService(String type) {
		if(type.equals("Monthly Receipt")){
            return new landlineServices();
        }
        return null;
	}


}
