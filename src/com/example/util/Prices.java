package com.example.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Prices {

    public static int range(int startRange, int endRange) {
        return ThreadLocalRandom.current().nextInt(startRange,endRange);
    }

}
