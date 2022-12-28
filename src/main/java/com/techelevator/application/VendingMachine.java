package com.techelevator.application;

import com.techelevator.models.*;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class VendingMachine {

    UserOutput userOutput = new UserOutput();
    UserInput userInput = new UserInput();
    Inventory Inventory = new Inventory();
    List<BigDecimal> moneyList = new ArrayList<>();
    FeedMoney money = new FeedMoney();
    Munchy munchy = new Munchy();
    Candy candy = new Candy();
    Drink drink = new Drink();
    Gum gum = new Gum();
    FileReader fileReader = new FileReader();
    List<VendingItem> newList = fileReader.readingFile();
    Map<String, Integer> stockList = Inventory.stocksVendingMachineStart();
    Transaction transaction = new Transaction();

    public void run() {

        while (true) {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if (choice.equals("display")) {
                Inventory.displayInventory();
            }

            // if customer choose "purchase"
            else if (choice.equals("purchase")) {
                // write a new method that deal with the purchase
                BigDecimal newAmount = new BigDecimal("0.0");
                while (true) {
                    // return homescreen menu
                    String input = userInput.HomeScreenMenu();

                    if (input.equals("feed money")) {
                        newAmount =money.returnCurrentMoneyProvided();
                        System.out.println("Current Money Provided" + "  $" + newAmount);

                    } else if (input.equals("select")) {

                        //for (VendingItem eachItem : newList) {
                            //System.out.println(eachItem + "" + stockList.get(eachItem.getLocation()));
                       // }
                        Inventory.displayInventory();
                        String choiceForLocation = userInput.askCustomerForItem();

                        //If the item (slot identifier) does not exist, the customer is informed and returned to the Purchase menu.
                        if (!checkAvailableSlotLocation(choiceForLocation) && (!checkAvailableProduct(choiceForLocation))) {
                            System.out.print(Inventory.selectingItemName(choiceForLocation) + ", ");
                            System.out.println(Inventory.displayItemPrice(choiceForLocation) + ", ");


                            // create new method that deals with calculate the remaining amount after each purchase!!

                            BigDecimal remaining = newAmount.subtract(Inventory.displayItemPrice(choiceForLocation));
                            if (newAmount.compareTo(Inventory.displayItemPrice(choiceForLocation)) == -1) {
                                System.out.println("Not Enough Funds!");
                                break;
                            }
                            System.out.print(remaining + ", ");

                            System.out.println(makeSound(choiceForLocation)); // this works

                            Inventory.subtractFromInventory(choiceForLocation);
                        } else if (checkAvailableSlotLocation(choiceForLocation)) {
                            System.out.println("This is not Valid Slot Location!!");
                        }

                    } else if (input.equals("finish transaction")) {
                        //stop infinite while loop
                        System.out.println();

                        break;
                    }
                }
            } else if (choice.equals("exit")) {
                // good bye
                break;
            }


        }
    }
    //print the sound
    public String makeSound(String location) {
        String message = "";
        String name = Inventory.getItem(location);
        if (name.equals("Munchy")) {
            message = munchy.Sound(location);
        } else if (name.equals("Candy")) {
            message = candy.Sound(location);
        } else if (name.equals("Drink")) {
            message = drink.Sound(location);
        } else {
            message = gum.Sound(location);
        }
        return message;


    }


    //If the item (slot identifier) does not exist, the customer is informed and returned to the Purchase menu.
    private boolean checkAvailableSlotLocation(String location) {
        boolean result = false;
        if (!stockList.containsKey(location)) {
            result = true;
        }
        return result;
    }

    private boolean checkAvailableProduct(String location) {
        boolean message = false;
        if (!checkAvailableSlotLocation(location)) {
            if (stockList.get(location) == 0) {
                message = true;
            }

        }
        return message;

    }
}



