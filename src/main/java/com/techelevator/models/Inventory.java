package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Inventory extends VendingItem {

    //array of strings for the items that are in the vending machine
    ArrayList<VendingItem> Inventory = new ArrayList<>();
    VendingItem item = new VendingItem();
    int quantity = 6;
    FeedMoney customerMoney = new FeedMoney();

    public List<VendingItem> readingFile() {

        String path = "catering.csv";
        File cateringFile = new File(path);
        String line = "";
        //customer input
        try (Scanner reader = new Scanner(cateringFile)) {
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                //split now as shown in instructions
                String[] lineOfText = line.split(",");
                String location = lineOfText[0];
                String itemName = lineOfText[1];
                BigDecimal itemPrice = new BigDecimal(lineOfText[2]);
                String itemType = lineOfText[3];
                VendingItem item = new VendingItem(location, itemName, itemPrice, itemType, quantity);
                Inventory.add(item);
            }
        } catch (FileNotFoundException e) {
            System.exit(1);
        }
        return Inventory;
    }


    public int dispenseItem() {
        if (getQuantity() >= 1) {
            return getQuantity() - 1;
        } else {
            return 1;
        }
    }

    public String selectingItemName(String userLocation) {
        for (VendingItem item : Inventory) {
            if (userLocation.equals(item.getLocation()) && item.getQuantity() >= 1) {
                return item.getItemName();
            }
        }
        return item.getItemName();
    }

    public BigDecimal displayItemPrice(String userLocation) {
        for (VendingItem item : Inventory) {
            if (userLocation.equals(item.getLocation()) && item.getQuantity() >= 1) {
                return item.getItemPrice();

            }
        }
        return item.getItemPrice();
    }

    public String SoundMessage(String userLocation) {
        String message = "";
        for (VendingItem item : Inventory) {
            if (userLocation.equals(item.getLocation())){

                if (item.getItemType().equals("Drink")) {
                    message = "Drinky, Drinky, Slurp Slurp!";
                } else if (item.getItemType().equals("Gum")) {
                    message = "Chewy, Chewy, Lots O Bubbles!";
                } else if (item.getItemType().equals("Candy")) {
                    message = "Sugar, Sugar, so Sweet!";
                } else if (item.getItemType().equals("Munchy"))
                    message = "Munchy, Munchy, so Good!";
                return message;
            }

        }
        return message;
    }
}

    /*
    public BigDecimal remainingMoney(String userLocation) {
        for (VendingItem item : Inventory) {
            if (userLocation.equals(item.getLocation()) && item.getQuantity() >= 1) {
                BigDecimal remainingAmount = customerMoney.totalFeedMoney() - (item.getItemPrice());
                return remainingAmount;
            }

        }
        return remainingAmount;
    }

     */

