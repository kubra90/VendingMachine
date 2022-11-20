package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends VendingItem implements SoundInterface{

    public Candy(String location, String itemName, BigDecimal itemPrice, String itemType, int quantity) {
        super(location, itemName, itemPrice, itemType, quantity);
    }

    @Override
    public String Sound(){
        if((super.getItemName()).equals("Candy")){
            ;
        }
        return "Sugar, Sugar, so Sweet!";
    }
}
