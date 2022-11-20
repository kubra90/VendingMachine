package com.techelevator.models;

import java.math.BigDecimal;


//All munchy items print
public class Munchy extends VendingItem implements SoundInterface{
    public Munchy(String location, String itemName, BigDecimal itemPrice, String itemType, int quantity) {
        super(location, itemName, itemPrice, itemType, quantity);
    }

    //if else statement to check the item Munchy or not
    //public String toString() {
      //  return "Munchy, Munchy, so Good!";
    //}


    @Override
    public String Sound(){
        if((super.getItemName()).equals("Munchy")){
            return "Munchy, Munchy, so Good!";
        }
        return "Munchy, Munchy, so Good!";
    }
}
