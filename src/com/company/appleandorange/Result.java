package com.company.appleandorange;

import java.util.List;

public class Result {
    /*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here

        int totalApples = 0;
        int totalOranges = 0;

        for (Integer apple : apples) {
            if (a + apple >= s && a + apple <= t) {
                totalApples++;
            }
        }

        for (Integer orange : oranges) {
            if (b + orange >= s && b + orange <= t) {
                totalOranges++;
            }
        }


        System.out.println(totalApples);
        System.out.println(totalOranges);
    }
}
