package com.company.IdeaProjects.FawryService.Models;

public class WalletPayment implements iPayment{
    private float totalPayment;
    databaseEntity entity =databaseEntity.getInstance();
    @Override
    public float pay(transaction transaction) {
        totalPayment=transaction.amountOfTrans;
        return totalPayment;
    }

}
