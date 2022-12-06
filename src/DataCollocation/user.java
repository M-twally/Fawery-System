package DataCollocation;

import java.util.Vector;

public class user {
    String userName;
    String email;
    String Password;
    float walletBalance;
    Vector<transaction>transactionsVector=new Vector<>();

    public user(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        Password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Vector<transaction> getTransactionsVector() {
        return transactionsVector;
    }
    public  void getUserTransactions(){
        for (DataCollocation.transaction transaction: transactionsVector) {
            System.out.print("transactionServiceType:");
            System.out.println(transaction.transactionServiceType);
            System.out.print("transactionType:");
            System.out.println(transaction.transactionType);
            System.out.println("amountOfTrans:");
            System.out.println(transaction.amountOfTrans);
        }
    }

    public void setTransactionsVector(Vector<transaction> transactionsVector) {
        this.transactionsVector = transactionsVector;
    }


}
