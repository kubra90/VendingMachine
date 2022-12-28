package com.techelevator.models;

public class Candy implements SoundInterface{

    @Override
    public String Sound(String location) {
        return "Sugar, Sugar, so Sweet!";
    }
}
