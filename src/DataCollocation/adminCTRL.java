package DataCollocation;

public class adminCTRL {
         databaseEntity entity =databaseEntity.getInstance();
         public void updateOverallDiscount(int amount){
                 entity.setOverallDiscount(amount);
         }
         public void updateSpecificDiscount(String name,int amount){
                entity.setSpecificDiscount(name, amount);
         }
         public void showAllUser(){

            entity.getUsers();
        }


}
