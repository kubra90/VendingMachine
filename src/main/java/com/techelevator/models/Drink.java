package com.techelevator.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Drink implements SoundInterface{

    @Override
    public String Sound(String location) {
        return "Drinky, Drinky, Slurp Slurp!";
    }
}
