package Services;

public class LandlineQuarterReceipt  extends factoryServiceProvider {

    @Override
    public serviceProduct createService(String type) {
        if(type.equals("Quarter Receipt")){
            return new landlineServices();
        }
        return null;
    }
}
