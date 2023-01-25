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


public class VendingMachine {

    UserOutput userOutput = new UserOutput();
    UserInput userInput = new UserInput();
    Inventory Inventory = new Inventory();
    FeedMoney money = new FeedMoney();
    Munchy munchy = new Munchy();
    Candy candy = new Candy();
    Drink drink = new Drink();
    Gum gum = new Gum();
    FileReader fileReader = new FileReader();
    List<VendingItem> newList = fileReader.readingFile();
    Map<String, Integer> stockList = Inventory.stocksVendingMachineStart();
    Transaction transaction = new Transaction();
    Logger logger = new Logger("Audit.txt");

    public VendingMachine(){

    }

    public void run() {

        while (true) {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if (choice.equals("display")) {
                Inventory.displayInventory(newList);
            }
            // if customer choose "purchase"
            else if (choice.equals("purchase")) {
                //BigDecimal newAmount = new BigDecimal("0.0");
                while (true) {
                    // return homescreen menu
                    String input = userInput.HomeScreenMenu();

                    if (input.equals("feed money")) {
                        displayMenuFeedMoney();

                    } else if (input.equals("select")) {
                        displayMenuWithSelect();

                    } else if (input.equals("finish transaction")) {
                       displayMenuFinishTransaction();
                        break;
                    }
                }
            } else if (choice.equals("exit")) {
                System.out.println("Come back again!");
                break;
            }
        }
    }
    //print the sound
    public String makeSound(String location) {
        String message = "";
        String name = Inventory.getItem(location, newList);
        if (name.equals("Munchy")) {
            message = munchy.Sound(location);
        } else if (name.equals("Candy")) {
            message = candy.Sound(location);
        } else if (name.equals("Drink")) {
            message = drink.Sound(location);
        } else if(name.equals("Gum")){
            message = gum.Sound(location);
        }
        return message;


    }

    public void displayMenuWithSelect() {
        Inventory.displayInventory(newList);
        while(true) {
            String choiceForLocation = getCustomerChoice();
            BigDecimal amount = money.getCurrentMoneyProvided();
            if (amount.compareTo(Inventory.displayItemPrice(choiceForLocation, newList)) == -1) {
                System.out.println("Not Enough Funds!");
                //break;
            } else if (!checkAvailableSlotLocation(choiceForLocation) && (!checkAvailableProduct(choiceForLocation))) {
                System.out.println("Purchased Item= " + Inventory.selectingItemName(choiceForLocation, newList) +
                        "\nPrice= $" + Inventory.displayItemPrice(choiceForLocation, newList) + "\n" +
                        "The change amount = $" + money.getRemainingAfterPurchase(choiceForLocation, newList) +
                        "\n" + makeSound(choiceForLocation));

                Inventory.subtractFromInventory(choiceForLocation);
                logger.auditFileWrite(Inventory.selectingItemName(choiceForLocation, newList), choiceForLocation,
                        money.totalFeedMoneyToString(), money.remainingToString());

                money.decreaseTotalMoneyAfterPurchase(choiceForLocation, newList);

            } else if (checkAvailableSlotLocation(choiceForLocation)) {
                System.out.println("This is not Valid Slot Location!!");
            }
            break;
        }

    }

    public String getCustomerChoice(){
       String result = userInput.askCustomerForItem();
       return result;
    }

    public void displayMenuFinishTransaction(){
        String message =transaction.returnMoneyCoins(money.getBalance().doubleValue()); //get.doublebalance
        System.out.println(message);
        money.updateVendingMachineBalanceToZero();
        logger.auditFileWrite("CHANGE GIVEN: ", "  ",money.remainingToString(), money.zeroVendingMachineBalanceToString());
    }

    public BigDecimal displayMenuFeedMoney(){
        BigDecimal newAmount =money.returnCurrentMoneyProvided();
        System.out.println("Current Money Provided" + "  $" + newAmount);
        logger.auditFileWrite("MONEY FED:", " ",money.currentMoneytoString(), money.totalFeedMoneyToString());
        return newAmount;
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



