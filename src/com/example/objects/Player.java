package com.example.objects;

import java.util.HashMap;
import java.util.Map;

public class Player {

    int health = 10;
    int wallet = 0;
    Map<String,String> inventory = new HashMap<String,String>();

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public String getItem(String itemName) {
        return inventory.get(itemName);
    }

    public void addItem(String itemName, String qty) {
        inventory.put(itemName, qty);
    }

    public String getAllItems() {
        return inventory.toString();
    }

}

