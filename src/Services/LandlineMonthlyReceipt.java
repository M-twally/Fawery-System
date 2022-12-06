package Services;

public class LandlineMonthlyReceipt extends factoryServiceProvider {

    @Override
    public serviceProduct createService(String type) {
        if(type.equals("Monthly Receipt")){
            return new landlineServices();
        }
        return null;
    }
}
