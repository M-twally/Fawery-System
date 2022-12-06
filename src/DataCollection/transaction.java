package DataCollection;

public class transaction {
    int id;
    String transactionType;
    String transactionServiceType;
    float amountOfTrans;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public float getAmountOfTrans() {
        return amountOfTrans;
    }

    public void setAmountOfTrans(float amountOfTrans) {
        this.amountOfTrans = amountOfTrans;
    }

    public String getTransactionServiceType() {
        return transactionServiceType;
    }

    public void setTransactionServiceType(String transactionServiceType) {
        this.transactionServiceType = transactionServiceType;
    }
}
