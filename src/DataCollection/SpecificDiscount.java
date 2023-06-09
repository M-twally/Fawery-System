package DataCollection;

import java.util.HashMap;

public class SpecificDiscount extends Decorator{
    iPayment iPayment;
    HashMap<String,Integer> discount = new HashMap<String,Integer>();

    public SpecificDiscount(DataCollection.iPayment iPayment) {
        this.iPayment = iPayment;
    }
    @Override
    public float pay(transaction transaction) {
        databaseEntity entity =databaseEntity.getInstance();
        int dis =entity.getDiscounts().get(transaction.transactionServiceType);
        float totalPay;
        totalPay=(float)dis;
        totalPay=totalPay/100;
        float totalPayment=transaction.amountOfTrans*totalPay;
        return iPayment.pay(transaction)-totalPayment;
    }
}
