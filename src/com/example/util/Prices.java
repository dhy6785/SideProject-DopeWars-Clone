package com.example.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Prices {

    public static int range(int startRange, int endRange) {
        return ThreadLocalRandom.current().nextInt(startRange,endRange);
    }

    public static Map<Drugs,String> generateDrugsList() {
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
