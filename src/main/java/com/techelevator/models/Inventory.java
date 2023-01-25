package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Inventory {

    List<VendingItem> InventoryList = new ArrayList<>();
    public TreeMap<String, Integer> inventoryStockList = new TreeMap<>();

    FileReader readerObject = new FileReader();

    public Inventory() {

    }

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
    public void getAllInventory() {
        List<VendingItem> newList = readerObject.readingFile();
        InventoryList.addAll(newList);
    }


    public void displayInventory(List<VendingItem> inventoryList) {
        for (VendingItem eachItem : inventoryList) {
            System.out.println(eachItem + "" + inventoryStockList.get(eachItem.getLocation()));
        }
    }

    public void subtractFromInventory(String location){
        inventoryStockList.put(location, inventoryStockList.get(location) - 1);
    }


    public String selectingItemName(String userLocation,List<VendingItem> InventoryList) {
        String name ="";
        for (VendingItem item : InventoryList) {
            if (userLocation.equals(item.getLocation())) {
                name = item.getItemName();
            }
        }
        return name;
    }

    public BigDecimal displayItemPrice(String userLocation,  List<VendingItem> InventoryList) {
        BigDecimal price = new BigDecimal("0.00");
        for (VendingItem item : InventoryList) {
            //if (userLocation.equals(item.getLocation()) && item.getQuantity() >= 1) {
            if (userLocation.equals(item.getLocation())){
                price = item.getItemPrice();

            }
        }
        return price;
    }

    public String getItem(String location, List<VendingItem> InventoryList) {
        String itemName = "";
        for (VendingItem item : InventoryList) {
            if (location.equals(item.getLocation())) {
                itemName = item.getItemType();
            }
        }
        return itemName;
    }
}
