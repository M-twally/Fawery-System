package com.company.IdeaProjects.FawryService.Models;

public class OverallDiscounts extends  Decorator{
    iPayment iPayment;
    private float totalPayment;
    databaseEntity entity =databaseEntity.getInstance();

    public OverallDiscounts(com.company.IdeaProjects.FawryService.Models.iPayment iPayment) {
        this.iPayment = iPayment;
    }

    @Override
    public float pay(transaction transaction) {
        float dis=entity.getOverallDiscount()/100;
        totalPayment=iPayment.pay(transaction)*dis;
        return iPayment.pay(transaction)-totalPayment;
    }
}
