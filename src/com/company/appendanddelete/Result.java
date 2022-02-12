package com.company.appendanddelete;

import java.nio.charset.StandardCharsets;

public class Result {

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String from, String to, int operCount) {

        int commonLength = 0;

        for (int i = 0; i < Math.min(from.length(), to.length()); i++) {
            if (from.charAt(i) == to.charAt(i)) {
                commonLength++;
            } else break;
        }

        String response = "No";

        if ((from.length() + to.length() - 2 * commonLength) > operCount) {
            response = "No";
        } else if ((from.length() + to.length() - 2 * commonLength) % 2 == operCount % 2) {
            System.out.println("Yes");
        }
        else if ((from.length() + to.length() - operCount) < 0) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }


        return response;
    }
}
