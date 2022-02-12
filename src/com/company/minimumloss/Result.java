package com.company.minimumloss;

import java.util.*;

public class Result {

    public static int minimumLoss(List<Long> price) {
        // Write your code here
//        Long response = price.get(0);
//
//        for (int i = 0; i < price.size(); i++) {
//            int j = i + 1;
//            while (j < price.size()) {
//                long result = price.get(i) - price.get(j);
//                if (result >= 0 && result < response) {
//                    response = result;
//                }
//                j++;
//            }
//        }
//
//        return response.intValue();

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < price.size(); i++) {
            map.put(price.get(i), i);
        }
        System.out.println(map);
        Collections.sort(price);
        System.out.println(price);
        long minimum = Long.MAX_VALUE;
        for (int i = price.size() - 1; i > 0; i--) {
            if (map.get(price.get(i)) < map.get(price.get(i - 1))) {
                minimum = Math.min(price.get(i) - price.get(i - 1), minimum);
            }
        }

        return (int) minimum;
    }
}
