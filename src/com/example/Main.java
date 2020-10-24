package com.example;

import com.example.objects.Player;
import com.example.util.Drugs;
import com.example.util.Prices;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        int maxDays = 30;
        Player player = new Player();

        do {

            System.out.println(Drugs.COCAINE);
            System.out.println(maxDays);
            maxDays--;

        } while (maxDays > 0);


    }

    public Map<Drugs,String> generateDrugsList() {
        Map<Drugs, String> drugs = new HashMap<>();
        drugs.put(Drugs.COCAINE, Integer.toString(Prices.range(12000,30000)));
        drugs.put(Drugs.HEROIN, Integer.toString(Prices.range(5000,12000)));
        drugs.put(Drugs.ACID, Integer.toString(Prices.range(1000,4000)));
        drugs.put(Drugs.WEED, Integer.toString(Prices.range(300,800)));
        drugs.put(Drugs.SPEED, Integer.toString(Prices.range(100,300)));
        drugs.put(Drugs.LUDES, Integer.toString(Prices.range(10,90)));
        return drugs;
    }

}