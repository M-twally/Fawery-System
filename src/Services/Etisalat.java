package Services;

public class Etisalat extends factoryServiceProvider{
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
