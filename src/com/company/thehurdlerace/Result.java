package com.company.thehurdlerace;

import java.util.Collections;
import java.util.List;

public class Result {

    /*
     * Complete the 'hurdleRace' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY height
     */

    public static int hurdleRace(int k, List<Integer> height) {
        // Write your code here
        int response = 0;

        if (k > Collections.max(height)) {
            return response;
        } else {
            response = Collections.max(height) - k;
        }

//        for (Integer hurdles : height) {
//            if (hurdles > k && (hurdles - k) != 1) {
//                response = hurdles - k;
//            }
//        }

        return response;
    }
}
