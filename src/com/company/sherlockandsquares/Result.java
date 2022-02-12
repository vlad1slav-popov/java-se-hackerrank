package com.company.sherlockandsquares;

public class Result {

    /*
     * Complete the 'squares' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER a
     *  2. INTEGER b
     */

    public static int squares(int a, int b) {
        // Write your code here
        int counter = 0;
        int digit = 1;


        while (digit * digit < a) {
            digit++;
        }
        while (digit * digit <= b) {
            counter++;
            digit++;
        }


        return counter;
    }
}
