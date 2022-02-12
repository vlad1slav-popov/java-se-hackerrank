package com.company.pickingnumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {


    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here


        Collections.sort(a);
        List<Integer> subArr = new ArrayList<>();
//        Integer counter = 0;

//        for (int i = 0; i < a.size() - 1; i++) {
//            if (Math.abs(a.get(i) - a.get(i + 1)) <= 1) {
//                counter++;
//            } else {
//                subArr.add(counter);
//                counter = 0;
//            }
//        }

        for (int i = 0; i < a.size(); i++) {
            Integer counter = 1;
            int value = a.get(i);
            for (int j = i + 1; j < a.size(); j++) {
                if (Math.abs(value - a.get(j)) <= 1) {
                    counter++;
                }
            }
            if (counter == 1) {
                counter = 0;
            }
            subArr.add(counter);
        }


        return Collections.max(subArr);
    }

}
