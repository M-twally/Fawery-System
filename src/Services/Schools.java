package Services;

public class Schools extends factoryServiceProvider {

	@Override
	public serviceProduct createService(String type) {
		  if(type.equals("Schools")){
	             return new Donations();
	         }
	         return null;
	}
}
