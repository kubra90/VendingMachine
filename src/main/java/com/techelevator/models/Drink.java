package com.techelevator.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Drink {

    VendingItem item = new VendingItem();
    ArrayList<VendingItem> Inventory = new ArrayList<>();


    //@Override
    //public String Sound(){
    //  if((super.getItemType()).equals("Drink")) {
    //    return "Drinky, Drinky, Slurp Slurp!";
    //}
    //return "Drinky, Drinky, Slurp Slurp!";
    //}

    public String Sound() {
        String message ="";
        for (VendingItem item : Inventory) {

            if (item.getItemType().equals("Drink")) {
               message = "Drinky, Drinky, Slurp Slurp!";
            } else if (item.getItemType().equals("Gum")) {
               message =  "Chewy, Chewy, Lots O Bubbles!";
            } else if (item.getItemType().equals("Candy")) {
                message =  "Sugar, Sugar, so Sweet!";
            } else if (item.getItemType().equals("Munchy"))
            message =  "Munchy, Munchy, so Good!";
        }return message;
    }
}
