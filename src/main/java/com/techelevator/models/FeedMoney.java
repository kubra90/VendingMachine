package com.techelevator.models;

import com.techelevator.ui.UserInput;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class FeedMoney {


    //
    private double customerDeposit;
   // private double Nickels = 0.05;
   // private double dime = 0.10;
    //private double quarter = 0.25;
    //private double quantityOfNickels;
   // private double quantityOfDime;
   // private double quantityOfQuarter;
    private double currentMoneyProvided = 0.00;
    private BigDecimal decimalCurrentMoney;
    UserInput userInput = new UserInput();

    List<VendingItem> inventory = new ArrayList<>();


    public double getCurrentMoneyProvided() {
        return currentMoneyProvided;
    }

    public void setCurrentMoneyProvided() {

    }

    public BigDecimal getDecimalCurrentMoney() {
        return decimalCurrentMoney;
    }



    public double getCustomerDeposit() {
        return customerDeposit;
    }





    // calculate total feed money
    public BigDecimal totalFeedMoney(double customerDeposit) {
        currentMoneyProvided += customerDeposit;
        BigDecimal decimalCurrentMoney = new BigDecimal(currentMoneyProvided);
        decimalCurrentMoney = decimalCurrentMoney.setScale(2, RoundingMode.CEILING);
        return decimalCurrentMoney;
    }

    public BigDecimal returnCurrentMoneyProvided(){
        double doubleMoney = userInput.askFeedMoney();
        // this method print all money!
        BigDecimal newAmount = totalFeedMoney(doubleMoney);
        return newAmount;
        //System.out.println("Current Money Provided" + "  $" + newAmount);
    }

   // public BigDecimal checkBalance(double customerDeposit)
}
