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
        Map<Drugs,String> drugsList;

        int input;

        do {
            System.out.println(maxDays);
            System.out.println("1: Buy or Sell  2: View Inventory  3: Move onto next City");
            drugsList = Prices.generateDrugsList();
            System.out.println(drugsList.toString());
            input = scan.nextInt();
            switch(input) {
                case 1:
                    System.out.println("Buy/Sell");
                    break;
                case 2:
                    System.out.println("Inventory");
                    break;
                case 3:
                    System.out.println("Move Cities");
                    maxDays--;
                default:
                    // do nothing
            }


        } while (maxDays > 0);


    }

}