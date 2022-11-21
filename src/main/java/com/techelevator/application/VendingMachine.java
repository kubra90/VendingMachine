package com.techelevator.application;

import com.techelevator.models.Drink;
import com.techelevator.models.FeedMoney;
import com.techelevator.models.VendingItem;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;
import com.techelevator.models.Inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VendingMachine {

    public void run() {
        UserOutput userOutput = new UserOutput();
        UserInput userInput = new UserInput();
        Inventory inventory = new Inventory();
        List<BigDecimal> moneyList = new ArrayList<>();
        List<VendingItem> newList = new ArrayList<>();
        FeedMoney money = new FeedMoney();

        while (true) {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();
            //String submenu =userInput.HomeScreenMenu();

            //display items with Remaining amount
            if (choice.equals("display")) {
                newList = inventory.readingFile();
                for (VendingItem eachItem : newList) {
                    System.out.println(eachItem);
                }
            }

            // if customer choose "purchase"
            else if (choice.equals("purchase")) {
                BigDecimal totalMoney = new BigDecimal("0.0");
                while (true) {

                    System.out.println("M) Feed Money");
                    System.out.println("(S) Select Item");
                    System.out.println("(F) Finish Transaction");
                    Scanner input = new Scanner(System.in);
                    String userChoice = input.nextLine();

                    if (userChoice.equalsIgnoreCase("M")) {
                        System.out.println("put your money into Vending machine: ");
                        double doubleMoney = Double.parseDouble(input.nextLine());
                        BigDecimal newAmount = money.totalFeedMoney(doubleMoney);
                        System.out.println("Current Money Provided" + "  $" + newAmount);
                        totalMoney = totalMoney.add(newAmount);
                        //moneyList.add(totalMoney);

                    } else if (userChoice.equalsIgnoreCase("S")) {
                        //show  the list of all items
                        newList = inventory.readingFile();
                        for (VendingItem eachItem : newList) {
                            System.out.println(eachItem);
                        }
                        System.out.println("Which item do you want to buy?");
                        String choiceForLocation = input.nextLine();
                        System.out.print(inventory.selectingItemName(choiceForLocation) + ", ");
                        System.out.println(inventory.displayItemPrice(choiceForLocation) + ", ");

                        BigDecimal remaining = totalMoney.subtract(inventory.displayItemPrice(choiceForLocation));
                        if (totalMoney.compareTo(inventory.displayItemPrice(choiceForLocation)) ==-1){
                            System.out.println("Not Enough Funds!");
                            break;
                        }
                        System.out.print(remaining + ", ");
                        System.out.println(inventory.SoundMessage(choiceForLocation));

                    } else if (userChoice.equalsIgnoreCase("F")) {
                        //stop infinite while loop
                        break;
                    }
                }
            }else if (choice.equals("exit")) {
                        // good bye
                        break;
                    }


                }
            }
        }


