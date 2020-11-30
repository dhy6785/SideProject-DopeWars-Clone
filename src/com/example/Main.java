package com.example;

import com.example.objects.Player;
import com.example.util.Drugs;
import com.example.util.Prices;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String title = "Welcome to Drug Wars! You have 30 days till the loan sharks collect!";

        int maxDays = 30;
        Player player = new Player();
        System.out.println(title);
        Scanner scan = new Scanner(System.in);
        Map<Drugs,String> drugsList = Prices.generateDrugsList();

        int input;

        do {
            System.out.println("Day: "+ maxDays);
            System.out.println("1: Buy  2: Sell 3: Move onto next City");

            System.out.println(drugsList.toString());
            input = scan.nextInt();
            switch(input) {
                case 1:
                    System.out.println("Buy");
                    buyDrugs(drugsList, player, scan);
                    break;
                case 2:
                    System.out.println("Sell");
                    sellDrugs(drugsList, player, scan);
                    break;
                case 3:
                    System.out.println("Move Cities");
                    drugsList = Prices.generateDrugsList();
                    maxDays--;
                default:
                    // do nothing
            }


        } while (maxDays > 0);

        scan.close();
    }

    public static void buyDrugs(Map<Drugs,String> drugsList, Player player, Scanner scan) {

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

        System.out.println("Drug: " + drug.toString() + " Price: " );
        int totalRemaining = (player.getWallet()) - (Integer.parseInt(drugsList.get(Drugs.valueOf(drug))) * amount);

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

    public static void sellDrugs(Map<Drugs,String> drugsList, Player player, Scanner scan) {

        // Drug selection
        String drug, purchase;
        int amount = player.getWallet();

        // Show the current list of drugs
        drugsList.toString();

        // Show the current amount of money to spend
        System.out.println("Current Money: " + player.getWallet());

        // Show the options to the player
        System.out.println("Which Drugs to sell?");
        drug = scan.nextLine();
        System.out.println("How much do you want to sell?");
        amount = scan.nextInt();

        int selectedDrugQuantity = player.getDrugQuantity(drug);
        int totalGained = player.getWallet() + (Integer.valueOf(drugsList.get(drug)) * amount);

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

}