package Services;

public class NGOs extends factoryServiceProvider {

	@Override
	protected serviceProduct createService(String type) {
		 if(type.equals("Non profitable organizations")){
             return new Donations();
         }
         return null;
	}

	

}
