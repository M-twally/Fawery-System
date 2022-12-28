package com.company.IdeaProjects.FawryService.Bsl;
import com.company.IdeaProjects.FawryService.Models.*;

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
            return "YOU SHOULD SIGNIN FIRST!";
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
    public String PaymentMethod(int id){
        iPayment iPay=null;
        float TotalPayment = 0;
        if(entity.getCurrentUser()==null){
            return "YOU SHOULD SIGNIN FIRST!";
        }else{
            if(id==2){
                iPay=new CashPayment();
                iPay=new OverallDiscounts(iPay);
                iPay=new SpecificDiscount(iPay);
                TotalPayment=iPay.pay(getTransactions());
            }else if(id==3){
                float wallet=entity.getCurrentUser().getWalletBalance();
                if(entity.getCurrentUser().getWalletBalance()==0){
                    return "YOUR WALLET BALANCE IS EMPTY";
                }
                iPay=new WalletPayment();
                iPay=new OverallDiscounts(iPay);
                iPay=new SpecificDiscount(iPay);
                TotalPayment=iPay.pay(getTransactions());
                if(TotalPayment<0){
                    return "YOUR WALLET BALANCE IS NOT ENOUGH";
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
        return "YOUR ALL TOTAL PAYMENT:"+TotalPayment;
    }
    private transaction getTransactions(){
        transaction t=new transaction();
        t.setTransactionType("Payment transaction");
        t.setTransactionServiceType(entity.getCurrentUser().getLastOpenForm());
        t.setAmountOfTrans(entity.getCurrentUser().getUserCurrentAmount());
        return t;
    }




}
