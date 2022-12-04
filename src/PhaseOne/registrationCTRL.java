package PhaseOne;

public class registrationCTRL {
    databaseEntity entity =new databaseEntity();
    public boolean signUp(String userName, String email, String password){
         user user =new user(userName, email,password);
         if(entity.checkingUserExist(email)){
//             System.out.println("user exist please signIn");
             return true;
         }else {
             entity.userVector.add(user);
             return false;
         }
    }
    public void showAllUser(){
        entity.getUsers();
    }
    public boolean signIN(String email,String password){
        if(entity.checkingUserData(email,password)){
            return true;
        }
        return false;
    }
    public void ShowUserData(String email,String password){
        entity.getUserData(email,password);
    }



}

