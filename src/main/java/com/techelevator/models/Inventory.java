package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;


//should we use inheritance in this part??? without inheritance it works too.
public class Inventory extends VendingItem {
    //this class should deal with the checking stocks , substractfromInventory
    //and it should return current inventory acc to slot location.
    // /array of strings for the items that are in the vending machine
    List<VendingItem> Inventory = new ArrayList<>();
    VendingItem item = new VendingItem();
    // map to keep track the location and the amount of all item.
    public TreeMap<String, Integer> inventoryStockList = new TreeMap<String, Integer>();

    FileReader readerObject = new FileReader();

    //two things importantto check inventory, one readerObject, second is quantity

    public Inventory() {

    }


    //initialize the stock at the beginning

    public Map<String, Integer> stocksVendingMachineStart() {
        int initialStock = 6;
        // you need to add each item the quantity
        List<VendingItem> newList = readerObject.readingFile();
        for (VendingItem item : newList) {
            inventoryStockList.put(item.getLocation(), initialStock);
        }
        return inventoryStockList;
    }

    public int returnCurrentInventory(String slotLocation) {
        return inventoryStockList.get(slotLocation);
    }



    // get all inventory by reading file
    public void getAllInventory(){
        List<VendingItem> newList = readerObject.readingFile();
        Inventory.addAll(newList);

    }


    public void displayInventory() {
       getAllInventory();
        for (VendingItem eachItem : Inventory) {
            System.out.println(eachItem + "" + inventoryStockList.get(eachItem.getLocation()));
        }
    }





    //return items in the inventory
/*
    public Map<String, Integer> checkTheStock() {

        for (VendingItem item : Inventory) {
            inventoryStockList.put(item.getLocation(), quantity);
        }
        return inventoryStockList;
    }




    public int dispenseFromInventory(String slotLocation) {
        for (VendingItem item : Inventory) {
            if (slotLocation.equals(item.getLocation())) {
                inventoryStockList.put(slotLocation, inventoryStockList.get(slotLocation) - 1);
                quantity = inventoryStockList.get(slotLocation) - 1;
            }
        }
        return quantity;
    }
    /*
    public ArrayList<VendingItem> updateInventory(){
        for (VendingItem item : Inventory) {

        }
    }
     */

    public void subtractFromInventory(String location){
        inventoryStockList.put(location, inventoryStockList.get(location) - 1);
    }


    public String selectingItemName(String userLocation) {
        getAllInventory();
        String name ="";
        for (VendingItem item : Inventory) {
            if (userLocation.equals(item.getLocation())) {
                name = item.getItemName();
            }
        }
        return name;
    }

    public BigDecimal displayItemPrice(String userLocation) {
        getAllInventory();
        BigDecimal price = new BigDecimal(0.0);
        for (VendingItem item : Inventory) {
            //if (userLocation.equals(item.getLocation()) && item.getQuantity() >= 1) {
            if (userLocation.equals(item.getLocation())){
                price = item.getItemPrice();

            }
        }
        return price;
    }

    //method to get Itemname

    public String getItem(String location) {
        String itemName = "";
        for (VendingItem item : Inventory) {
            if (location.equals(item.getLocation())) {
                itemName = item.getItemType();
            }
        }
        return itemName;
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

