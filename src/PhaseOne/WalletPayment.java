package PhaseOne;

public class WalletPayment implements iPayment{
    private float totalPayment;
    databaseEntity entity =databaseEntity.getInstance();
    @Override
    public float pay(transaction transaction) {
       totalPayment=entity.getCurrentUser().walletBalance-transaction.amountOfTrans;
       return totalPayment;
    }
}
