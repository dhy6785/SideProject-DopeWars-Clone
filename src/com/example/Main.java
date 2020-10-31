package com.example;

import com.example.objects.Player;
import com.example.util.Drugs;
import com.example.util.Prices;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String title = "Welcome to Drug Wars! You have 30 days til the loan sharks collect!";

        int maxDays = 30;
        Player player = new Player();
        System.out.println(title);
        Scanner scan = new Scanner(System.in);
        Map<Drugs,String> drugsList;

        do {

            System.out.println(Drugs.COCAINE);
            System.out.println(maxDays);
            drugsList = generateDrugsList();
            System.out.println("1: Buy or Sell  2: View Inventory  3: Move onto next City");
            System.out.println(drugsList.toString);
            maxDays--;

        } while (maxDays > 0);


    }

    public Map<Drugs,String> generateDrugsList() {
        Map<Drugs, String> drugs = new HashMap<Drugs, String>();
        drugs.put(Drugs.COCAINE, Integer.toString(Prices.range(12000,30000)));
        drugs.put(Drugs.HEROIN, Integer.toString(Prices.range(5000,12000)));
        drugs.put(Drugs.ACID, Integer.toString(Prices.range(1000,4000)));
        drugs.put(Drugs.WEED, Integer.toString(Prices.range(300,800)));
        drugs.put(Drugs.SPEED, Integer.toString(Prices.range(100,300)));
        drugs.put(Drugs.LUDES, Integer.toString(Prices.range(10,90)));
        return drugs;
    }




}