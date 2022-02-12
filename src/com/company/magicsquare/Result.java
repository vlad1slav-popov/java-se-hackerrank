package com.company.magicsquare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    /*
    5 3 4
    1 5 8
    6 4 2
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here

//        int convertCount = 0;
////        int sumStolb = 0;
//        int sumDiag = 0;
////        int sumObrDiag = 0;
//
//        List<Integer> sumlist = new ArrayList<>();
//
//
//        for (int i = 0; i < s.size(); i++) {
//            int sumStr = 0;
//            for (int j = 0; j < s.get(i).size(); j++) {
//                System.out.println("i: " + i + "; j: " + j + ": Value: " + s.get(i).get(j));
//                sumStr = sumStr + s.get(i).get(j);
//                if (i == j) {
//                    sumDiag = sumDiag + s.get(i).get(j);
//                }
//            }
//            System.out.println("SUM po stroke = " + sumStr);
//            sumlist.add(sumStr);
//        }

//        return convertCount;

        List<Integer> cost = new ArrayList<>();
        int[][] t = {
                        {4, 9, 2, 3, 5, 7, 8, 1, 6},
                        {4, 3, 8, 9, 5, 1, 2, 7, 6},
                        {2, 9, 4, 7, 5, 3, 6, 1, 8},
                        {2, 7, 6, 9, 5, 1, 4, 3, 8},
                        {8, 1, 6, 3, 5, 7, 4, 9, 2},
                        {8, 3, 4, 1, 5, 9, 6, 7, 2},
                        {6, 7, 2, 1, 5, 9, 8, 3, 4},
                        {6, 1, 8, 7, 5, 3, 2, 9, 4},
                };

        for (int i = 0; i < 8; i++) {
            cost.add(0);
        }


        for (int i = 0; i < 8; i++) {
            int j = 0;
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    cost.set(i, cost.get(i) + Math.abs(t[i][j] - s.get(k).get(l)));
                    j++;
                }
            }
        }

        Collections.sort(cost);

        return cost.get(0);
    }


}
