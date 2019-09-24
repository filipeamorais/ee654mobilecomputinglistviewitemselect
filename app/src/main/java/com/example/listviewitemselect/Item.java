package com.example.listviewitemselect;

public class Item {
    String flagName;
    int flagImage;

    public Item(String flagName, int flagImage){
        this.flagImage = flagImage;
        this.flagName = flagName;
    }

    public String getFlagName() {
        return flagName;
    }
    
    public int getFlagImage() {
        return flagImage;
    }

}
