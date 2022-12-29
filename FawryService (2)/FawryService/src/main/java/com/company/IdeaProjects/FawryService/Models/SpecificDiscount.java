package com.company.IdeaProjects.FawryService.Models;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SpecificDiscount extends Decorator{
    iPayment iPayment;
    HashMap<String,Integer> discount = new HashMap<String,Integer>();

    public SpecificDiscount(com.company.IdeaProjects.FawryService.Models.iPayment iPayment) {
        this.iPayment = iPayment;
    }
    @Override
    public float pay(transaction transaction) {
        databaseEntity entity =databaseEntity.getInstance();
        float dis=0F;
        for (Map.Entry<Integer, Pair<String,Float>> entry : entity.getIDSpecificDiscount().entrySet()) {
            if (Objects.equals(entry.getValue().getKey(), transaction.transactionServiceType)){
                dis= entry.getValue().getValue();
                break;
            }
        }
        float totalPay;
        totalPay=dis;
        totalPay=totalPay/100;
        float totalPayment=transaction.amountOfTrans*totalPay;
        return iPayment.pay(transaction)-totalPayment;
    }
}
