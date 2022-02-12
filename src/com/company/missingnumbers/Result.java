package com.company.missingnumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Result {


    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {

        List<Integer> result = new ArrayList<>(arr);

//        if (arr.size() > brr.size()) {
//            result = new ArrayList<>(arr);

        System.out.println(result);
        System.out.println(brr);

            for (int i = 0; i < arr.size(); i++) {
                for (int j = 0; j < brr.size(); j++) {
                    if (result.get(i).equals(brr.get(j))) {
                        result.remove(i);
                    }
                }
            }
//        } else {
//            result = new ArrayList<>(brr);
//            for (int i = 0; i < result.size(); i++) {
//                for (int j = 0; j < arr.size(); j++) {
//                    if (result.get(i).equals(arr.get(j))) {
//                        result.remove(i);
//                    }
//                }
//            }
//        }


        // Write your code here
        return result;
    }
}
