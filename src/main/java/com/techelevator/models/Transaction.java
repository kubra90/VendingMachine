package com.techelevator.models;

import java.math.BigDecimal;

public class Transaction {


    //the vending machine s balance
    private BigDecimal totalBalance;


    public BigDecimal getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }

    // after purchase update the balance of vending machine. Balance should be
    //"0"
   // public BigDecimal updateBalance(BigDecimal balance) { // refer to the total money
        //before updated balance and after
        // initialBalance = currentBalance;
        //currentbalance is the balance after the update and input is what is depositied in
        //currentBalance += inputBalance
        //balance = new BigDecimal(0);
        //return balance;
    //}
}
