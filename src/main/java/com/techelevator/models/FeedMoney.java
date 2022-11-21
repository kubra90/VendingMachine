package com.techelevator.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class FeedMoney{


    //
    private double customerDeposit;
    private double Nickels = 0.05;
    private double dime =0.10;
    private double quarter = 0.25;
    private double quantityOfNickels;
    private double quantityOfDime;
    private double quantityOfQuarter;
    private double currentMoneyProvided =0.00;
    private BigDecimal decimalCurrentMoney;

    VendingItem item = new VendingItem();


    public double getCurrentMoneyProvided(){
        return currentMoneyProvided;
    }

    public void setCurrentMoneyProvided() {

    }

    public BigDecimal getDecimalCurrentMoney() {
        return decimalCurrentMoney;
    }

    public double getNickels() {
        return Nickels;
    }

    public double getDime() {
        return dime;
    }

    public double getQuarter() {
        return quarter;
    }

    public double getQuantityOfNickels() {
        return quantityOfNickels;
    }

    public double getQuantityOfDime() {
        return quantityOfDime;
    }

    public double getCustomerDeposit() {
        return customerDeposit;
    }

    public double getQuantityOfQuarter() {
        return quantityOfQuarter;
    }


    public BigDecimal totalFeedMoney(double customerDeposit) {
        currentMoneyProvided += customerDeposit;
        BigDecimal decimalCurrentMoney = new BigDecimal(currentMoneyProvided);
        decimalCurrentMoney =decimalCurrentMoney.setScale(2, RoundingMode.CEILING);
        return decimalCurrentMoney;
    }


    public BigDecimal remainingMoney(){
        return decimalCurrentMoney.subtract(item.getItemPrice());
    }

    /*
    public String NotEnoughFunds(){
        BigDecimal newCustomerDeposit = new BigDecimal(customerDeposit);
        if ((item.getItemPrice().compareTo(newCustomerDeposit)) == 1) {
            System.out.println("Not Enough Funds! Please put more money into the Vending machine");
        }
        return "Not Enough Funds! Please put more money into the Vending machine";
    }

     */
}
