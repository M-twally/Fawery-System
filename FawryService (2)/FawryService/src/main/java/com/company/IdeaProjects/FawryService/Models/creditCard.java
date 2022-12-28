package com.company.IdeaProjects.FawryService.Models;

public class creditCard implements iPayment{
    private float totalPayment;
    @Override
    public float pay(transaction transaction) {
        totalPayment=transaction.amountOfTrans;
        return totalPayment;
    }
}
