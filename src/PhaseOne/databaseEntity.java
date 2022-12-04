package PhaseOne;
import java.util.Vector;
import java.util.Objects;


public class databaseEntity {
    Vector<user>userVector=new Vector<>();
    public Vector<user> getUserVector() {
           return userVector;
    }
    public void getUsers(){
           for (PhaseOne.user user : userVector) {
                  System.out.println(user.userName);
                  System.out.println(user.email);
           }
    }
    public boolean checkingUserExist(String email){
           for (PhaseOne.user user : userVector) {
                  if (Objects.equals(user.email, email)) {
                         return true;
                  }
           }
           return false;
    }

    public boolean checkingUserData(String email,String password){
           for (PhaseOne.user user : userVector) {
                  if (Objects.equals(user.email, email) && Objects.equals(user.Password, password)) {
                         return true;
                  }
           }
           return false;
    }
    public void getUserData(String email,String password){
           for (PhaseOne.user user : userVector) {
                  if (Objects.equals(user.email, email) && Objects.equals(user.Password, password)) {
                         System.out.println("UserName:"+user.userName);
                         System.out.println("email:"+user.email);
                         break;
                  }
           }
    }
}
