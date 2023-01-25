package com.techelevator.models;

import com.techelevator.ui.UserInput;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FeedMoney {
    //private double customerDeposit;

    private BigDecimal currentMoneyProvided = BigDecimal.ZERO;
    UserInput userInput = new UserInput();
    private BigDecimal balance =new BigDecimal("0.00");
    private BigDecimal vendingMachineBalance = BigDecimal.ZERO;
    private double doubleBalance = balance.doubleValue();
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private BigDecimal money= new BigDecimal("0.00");

    Inventory inventory = new Inventory();
    List<VendingItem> inventoryList = new ArrayList<>();

    public FeedMoney(){
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public void setCurrentMoneyProvided(BigDecimal currentMoneyProvided) {
        this.currentMoneyProvided = currentMoneyProvided;
    }

    public double getDoubleBalance() {
        return doubleBalance;
    }

    public void setDoubleBalance(double doubleBalance) {
        this.doubleBalance = doubleBalance;
    }

    public BigDecimal getCurrentMoneyProvided() {
        return currentMoneyProvided;
    }

    public BigDecimal getVendingMachineBalance() {
        return vendingMachineBalance;
    }

    public void setVendingMachineBalance(BigDecimal vendingMachineBalance) {
        this.vendingMachineBalance = vendingMachineBalance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    // calculate total feed money
    public BigDecimal totalFeedMoney(double customerDeposit) {

        currentMoneyProvided =currentMoneyProvided.add(BigDecimal.valueOf(customerDeposit));
        currentMoneyProvided = currentMoneyProvided.setScale(2, RoundingMode.CEILING);
        return currentMoneyProvided;
    }

    public BigDecimal getMoneyFromUser(){
        money =BigDecimal.valueOf(userInput.askFeedMoney());
        money =money.setScale(2, RoundingMode.CEILING);
        return money;
    }

    public BigDecimal returnCurrentMoneyProvided(){
       BigDecimal newAmount;

        newAmount=totalFeedMoney(getMoneyFromUser().doubleValue());
        return  newAmount;
   
    }
    //this code is work
 public BigDecimal getRemainingAfterPurchase(String location, List<VendingItem> inventoryList) {
     balance = currentMoneyProvided.subtract(inventory.displayItemPrice(location, inventoryList));
     return balance;
 }

 // get remaining with double price

    public double getRemainingDoubleAfterPurchase(String location, List<VendingItem> inventoryList) {
        balance = currentMoneyProvided.subtract(inventory.displayItemPrice(location, inventoryList));
        doubleBalance =balance.doubleValue();
        return doubleBalance;
    }



    public BigDecimal convertToDecimal(double currentMoneyProvided){
        BigDecimal decimalCurrentMoney = new BigDecimal(currentMoneyProvided);
        decimalCurrentMoney = decimalCurrentMoney.setScale(2, RoundingMode.CEILING);
        return decimalCurrentMoney;

    }

    //update vendingmachine balance after giving back the remaining to the customer
    public BigDecimal updateVendingMachineBalanceToZero(){
       currentMoneyProvided = new BigDecimal("0.00");
       return currentMoneyProvided;
    }


    public BigDecimal decreaseTotalMoneyAfterPurchase(String location, List<VendingItem> inventoryList){
        double amount =inventory.displayItemPrice(location, inventoryList).doubleValue();
        currentMoneyProvided= currentMoneyProvided.subtract(BigDecimal.valueOf(amount));
        currentMoneyProvided = (currentMoneyProvided.setScale(2, RoundingMode.CEILING));
        return currentMoneyProvided;
    }


    public String currentMoneytoString() {
        return "$" + getMoney();
    }

    public String totalFeedMoneyToString(){
        return "$" + currentMoneyProvided;
    }

    public String changeToString(){
        doubleBalance =Double.parseDouble(String.format("%.2f", doubleBalance));
        return "$" + doubleBalance;
    }

    public String remainingToString(){
        return "$" + balance;
    }

    public String zeroVendingMachineBalanceToString(){
        return "$" + updateVendingMachineBalanceToZero();
    }


}
