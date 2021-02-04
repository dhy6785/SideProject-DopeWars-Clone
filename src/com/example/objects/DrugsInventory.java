package com.example.objects;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.example.util.Drugs;
import com.example.util.Prices;

public class DrugsInventory {

    private enum DRUGS {
        LUDES, SPEED, WEED, ACID, HEROIN, COCAINE
    }

    private Map<DRUGS,String> drugsList;


    // Constructor
    public DrugsInventory() {
        drugsList = generateDrugsList();
    }

    public Map<DRUGS, String> getDrugsList() {
        return drugsList;
    }

    public void setDrugsList(Map<DRUGS, String> drugsList) {
        this.drugsList = drugsList;
    }


    public void buyDrugs(Map<DRUGS,String> drugsList, Player player, Scanner scan) {

        // Drug selection
        String drug, purchase;
        int amount;

        // Show the current list of drugs
        drugsList.toString();

        // Show the current amount of money to spend
        System.out.println("Current Money: " + player.getWallet());

        // Show the options to the player
        System.out.print("Which Drugs to buy? ");
        scan.nextLine();
        drug = scan.nextLine();
        System.out.println("Input: " + drug);

        System.out.println("How much do you want? ");
        amount = scan.nextInt();
        scan.nextLine();
        System.out.println("Input: " + amount);

        System.out.println("Drug: " + drug + " Price: " );
        int totalRemaining = (player.getWallet()) - (Integer.parseInt(drugsList.get(DRUGS.valueOf(drug))) * amount);

        if(totalRemaining < 0) {
            System.out.println("You don't have enough money");
        } else {
            // Update player's wallet funds
            player.setWallet(player.getWallet() - totalRemaining);

            System.out.println("You have : " + totalRemaining + " remaining and obtained " + amount + " drug " + drug);

            // Update player's inventory
            player.addItem(drug, String.valueOf(amount));
        }


    }

    public void sellDrugs(Map<DRUGS,String> drugsList, Player player, Scanner scan) {

        // Drug selection
        String drug, purchase;
        int wallet = player.getWallet();

        // Show the current list of drugs
        drugsList.toString();

        // Show the current amount of money to spend
        System.out.println("Current Money: " + player.getWallet());

        // Show the options to the player
        System.out.println("Which Drugs to sell?");
        drug = scan.nextLine();
        System.out.println("How much do you want to sell?");
        int amount = scan.nextInt();

        int selectedDrugQuantity = player.getDrugQuantity(drug);
        int totalGained = wallet + Integer.valueOf(drugsList.get(drug) * amount); //TODO fix: get price of drug then multiply by amount sold

        // Check if we have the necessary amount of that drug
        if(player.getDrugQuantity(drug) > 0 ) {
            // Update player's wallet funds
            player.setWallet(player.getWallet() + totalGained);

            // Update player's inventory
            player.addItem(drug, String.valueOf((selectedDrugQuantity - amount)));
        } else {
            System.out.println("You don't have enough of that drug");
        }

    }

    public Map<DRUGS,String> resetDrugsList() {
        return generateDrugsList();
    }

    private Map<DRUGS,String> generateDrugsList() {
        Map<DRUGS, String> drugs = new HashMap<>();

        drugs.put(DRUGS.COCAINE, Integer.toString(Prices.range(12000,30000)));
        drugs.put(DRUGS.HEROIN, Integer.toString(Prices.range(5000,12000)));
        drugs.put(DRUGS.ACID, Integer.toString(Prices.range(1000,4000)));
        drugs.put(DRUGS.WEED, Integer.toString(Prices.range(300,800)));
        drugs.put(DRUGS.SPEED, Integer.toString(Prices.range(100,300)));
        drugs.put(DRUGS.LUDES, Integer.toString(Prices.range(10,90)));

        return drugs;
    }

}
