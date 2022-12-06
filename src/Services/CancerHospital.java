package Services;

public class CancerHospital extends factoryServiceProvider {

	@Override
	public serviceProduct createService(String type) {
		  if(type.equals("Cancer Hospital")){
	             return new Donations();
	         }
	         return null;
	}

	

}
