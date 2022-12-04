package PhaseOne;

import java.util.HashMap;

public class userCTRL {
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
    public void addWallet(float amount){
    	  entity.addToWallet(amount);
    	  }
    	public HashMap<String, Integer> showSpecialDiscounts(){
    	    return entity.getDiscounts();
    	    }
    	public int ShowOverallDiscount()
    	{
    	    return entity.getOverallDiscount();
    	    }



}

