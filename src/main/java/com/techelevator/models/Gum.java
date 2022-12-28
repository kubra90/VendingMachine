package com.techelevator.models;

import java.math.BigDecimal;


// we print out sound and inventory!
public class Gum implements SoundInterface {
    @Override
    public String Sound(String location) {
        return "Chewy, Chewy, Lots O Bubbles!";
    }

}
