package com.techelevator.models;

import java.math.BigDecimal;

public class Transaction {

   private int nickels = 5;
   private int dime =10;
   private int quarter = 25;
   private int quantityOfNickels;
   private int quantityOfDime;
   private int quantityOfQuarter;
   private int quantityOfPennies;
   private int dollar = 100;
   public double returnMoney;
   FeedMoney money = new FeedMoney();

    public Transaction(){
        this.returnMoney = money.getDoubleBalance();
    }

    //public double getReturnMoney() {
      //  return returnMoney;
    //}

    //public void setReturnMoney(double returnMoney) {
      //  this.returnMoney = returnMoney;
    //}


    public String returnMoneyCoins(double money){

        long balanceLong =(Math.round(money * 100));
        int balance =(int)balanceLong;
        int quantityDollars = balance/ dollar;
        int dollarValue = balance % dollar;
        quantityOfQuarter=  dollarValue / quarter;
        int value = dollarValue % quarter;
        quantityOfDime = value / dime;
        int value2 = value % dime;
        quantityOfNickels = value2/ nickels;
        int value3 = value2 % 5;
        quantityOfPennies= value3;


        String returnChange = "Your Change\n" + "------------\n"+
                "quantity of dollars = " + quantityDollars +"\nquantity of quarter = " + quantityOfQuarter + "\nquantity of dime = " + quantityOfDime+
                "\nquantity of nickels = " + quantityOfNickels+ "\nquantity of pennies = " + quantityOfPennies;

        return returnChange;


        }
    }
