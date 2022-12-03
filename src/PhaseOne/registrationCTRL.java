package PhaseOne;
import java.util.Objects;



public class registrationCTRL {
    databaseEntity entity =new databaseEntity();
    public void signUp(String userName, String email, String password){
         user user =new user(userName, email,password);
         if(checkingUserExist(email)){
             System.out.println("user exist please signIn");
             //signIn fun
         }else{
         entity.userVector.add(user);}
    }
    public boolean checkingUserExist(String email){
        for(int i=0;i<entity.userVector.size();i++){
            if(Objects.equals(entity.userVector.get(i).email, email)){
                return true;
            }
        }
        return false;
    }

}
