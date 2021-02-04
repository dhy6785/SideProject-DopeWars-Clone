package com.example;

import com.example.objects.DrugsInventory;
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
        DrugsInventory drugsInv= new DrugsInventory();

        int input;

        do {
            System.out.println("Day: "+ maxDays);
            System.out.println("1: Buy  2: Sell 3: Move onto next City");

            System.out.println(drugsInv.getDrugsList().toString());
            input = scan.nextInt();
            switch(input) {
                case 1:
                    System.out.println("Buy");
                    drugsInv.buyDrugs(drugsInv.getDrugsList(), player, scan);
                    break;
                case 2:
                    System.out.println("Sell");
                    drugsInv.sellDrugs(drugsInv.getDrugsList(), player, scan);
                    break;
                case 3:
                    System.out.println("Move Cities");
                    drugsInv.setDrugsList(drugsInv.resetDrugsList());
                    maxDays--;
                default:
                    // do nothing
            }


        } while (maxDays > 0);

        scan.close();
    }

}