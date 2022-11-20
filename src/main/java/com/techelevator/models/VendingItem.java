package com.techelevator.models;

import java.math.BigDecimal;

public class VendingItem {

        private String location;
        private String itemName;
        private BigDecimal itemPrice;
        private String itemType;
        private int quantity;

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getItemPrice() {
            return itemPrice;
        }


        public void setItemPrice(BigDecimal itemPrice) {
            this.itemPrice = itemPrice;
        }

        public String getItemType() {
            return itemType;
        }


        public void setItemType(String itemType) {
            this.itemType = itemType;
        }

        public VendingItem(String location, String itemName, BigDecimal itemPrice, String itemType, int quantity) {

            this.location = location;
            this.itemName = itemName;
            this.itemPrice = itemPrice;
            this.itemType = itemType;
            this.quantity =quantity;
        }

        public VendingItem(){

        }


        // string representation of an object
        @Override
        public String toString(){
            return location + ", " + itemName + ", " + itemPrice + " ," + itemType + ", " + quantity;
        }

        // method for message!
        public String sound(){
            return "message";
        }

}







