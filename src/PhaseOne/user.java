package PhaseOne;
import java.util.Vector;

public class user {
	  String userName;
	    String email;
	    String Password;
	    static int  phoneNumber;
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

	    public void setTransactionsVector(Vector<transaction> transactionsVector) {
	        this.transactionsVector = transactionsVector;
	    }

}
