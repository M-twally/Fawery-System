package Services;

public abstract class  factoryServiceProvider {
    public   abstract serviceProduct createService(String type);

    public  serviceProduct orderForm(String string,String name){
        serviceProduct service=createService(string);
        service.createForm(name);
        return service;
    }
}
