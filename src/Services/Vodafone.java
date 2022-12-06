package Services;

public class Vodafone extends factoryServiceProvider {

	@Override
	public serviceProduct createService(String type) {
		   if(type.equals("Mobile Recharge")){
	             return new MobileRechargeServices();
	         }else if(type.equals("Internet Payment services")){
	             return new InternetPaymentServices();
	         }
	         return null;
	
	}
}
