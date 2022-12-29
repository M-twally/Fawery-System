package com.company.IdeaProjects.FawryService.Bsl;
import com.company.IdeaProjects.FawryService.Models.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class UserBSl {
    databaseEntity entity =databaseEntity.getInstance();
    public String SignUP(user user){
        for(int i=0;i<entity.getUserVector().size();i++){
            if(Objects.equals(entity.getUserVector().get(i).getEmail(), user.getEmail())){
                return "THIS USER ALREADY EXIST!";
            }
        }
        entity.getUserVector().add(user);
        return "SIGNUP SUCCESSFULLY !";
    }
    public String signIn(user user){
        for (int i=0;i<entity.getUserVector().size();i++) {
            if (Objects.equals(entity.getUserVector().get(i).getEmail(), user.getEmail()) && Objects.equals(entity.getUserVector().get(i).getPassword(), user.getPassword())) {
                entity.setCurrentUser(entity.getUserVector().get(i));
                return "WELCOME BACK!";
            }
        }
        return "PLEASE SIGN UP FIRST!";
    }
    public String addWallet(float amount){
        if(entity.getCurrentUser()==null){
            return "YOU SHOULD SIGNING FIRST!";
        }else {
            entity.saveToWallet(amount);
            transaction t=new transaction();
            t.setTransactionType("Add to wallet transaction");
            t.setAmountOfTrans(amount);
            entity.getCurrentUser().getTransactionsVector().add(t);
        }
        return "ADDING amount:"+amount+" SUCCESSFUL YOUR WALLET BALANCE:"+entity.getCurrentUser().getWalletBalance();
    }
    public user ShowCurrentUserData(){
        if(entity.getCurrentUser()!=null){
            return entity.getCurrentUser();
        }
        return null;
    }
    public ArrayList<String> PaymentMethod(int id){
        iPayment iPay;
        float TotalPayment;
        ArrayList<String> message=new ArrayList<>();
        if(entity.getCurrentUser()==null){
            message.add("YOU SHOULD SIGNING FIRST!");
            return message;
        }else{
            if(id==2){
                iPay=new CashPayment();
                iPay=new OverallDiscounts(iPay);
                iPay=new SpecificDiscount(iPay);
                TotalPayment=iPay.pay(getTransactions());
            }else if(id==3){
                if(entity.getCurrentUser().getWalletBalance()==0){
                    message.add("YOUR WALLET BALANCE IS EMPTY");
                    return message;
                }
                iPay=new WalletPayment();
                iPay=new OverallDiscounts(iPay);
                iPay=new SpecificDiscount(iPay);
                TotalPayment=iPay.pay(getTransactions());

                if(TotalPayment<-1){
                    message.add("YOUR WALLET BALANCE IS NOT ENOUGH");
                    return message;
                }
                float sub=entity.getCurrentUser().getWalletBalance()-getTransactions().getAmountOfTrans();
                TotalPayment=entity.getCurrentUser().getWalletBalance()-sub;
                entity.getCurrentUser().setWalletBalance(sub);
            }else{
                iPay=new creditCard();
                iPay=new OverallDiscounts(iPay);
                iPay=new SpecificDiscount(iPay);
                TotalPayment=iPay.pay(getTransactions());
            }
        }
        transaction t=getTransactions();
        t.setAmountOfTrans(TotalPayment);
        entity.getCurrentUser().getTransactionsVector().add(t);

        if(entity.getOverallDiscount()!=0){
            String discount="AFTER ADDING OVER ALL DISCOUNT:"+entity.getOverallDiscount()+"%";
            message.add(discount);
        }
        float SPdis=GETSpecialDiscount(entity.getCurrentUser().getLastOpenForm());
        if(SPdis!=0){
            String discount="SPECIFIC DISCOUNT FOR"+entity.getCurrentUser().getLastOpenForm()+":"+SPdis+"%";
            message.add(discount);
        }
        message.add("YOUR ALL TOTAL PAYMENT:"+TotalPayment);
        return message;
    }
    private transaction getTransactions(){
        transaction t=new transaction();
        t.setTransactionType("Payment transaction");
        t.setTransactionServiceType(entity.getCurrentUser().getLastOpenForm());
        t.setAmountOfTrans(entity.getCurrentUser().getUserCurrentAmount());
        return t;
    }
    private float GETSpecialDiscount(String SpecialDiscount){
        for (Map.Entry<String,Integer> entry : entity.getDiscounts().entrySet()) {
            if (Objects.equals(SpecialDiscount, entry.getKey())){
                return entry.getValue();
            }
        }
        return 0.0F;
    }

}
