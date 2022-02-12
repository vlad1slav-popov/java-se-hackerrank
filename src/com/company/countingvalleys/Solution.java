package com.company.countingvalleys;

import java.util.Scanner;

public class Solution {


    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int valleys = 0;
        int currLvl = 0;

        for (char ch : path.toCharArray()) {
            if (ch == 'U') {
                currLvl++;
            }
            if (ch == 'D') {
                currLvl--;
            }

            if (currLvl == 0 && ch == 'U') {
                valleys++;
            }

        }

        return valleys;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int steps = scanner.nextInt();
        String path = scanner.next();

        int valleys = countingValleys(steps, path);

        System.out.println(valleys);


    }
}
