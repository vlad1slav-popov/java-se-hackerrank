package com.company.climbingtheleaderboard;

import java.util.*;

public class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
//
//        Set<Integer> rankedSet = new HashSet<>(ranked);
//        List<Integer> resultList = new ArrayList<>();
//
//        for (Integer rank : rankedSet) {
//            Integer result = rankedSet.size() + 1;
//
//            for (Integer playerRes : player) {
//                if (playerRes >= rank) {
//                    result--;
//                }
//            }
//
//            resultList.add(result);
//        }
//
//        return resultList;

        int[] results = new int[player.size()];
        int rank = 1;
        int rankScore = ranked.get(0);

        for (int a = player.size() - 1, s = 0; a >= 0; a--) {
            if (player.get(a) < rankScore) {
                for (; s < ranked.size(); s++) {
                    if (ranked.get(s) < rankScore) {
                        rank++;
                        rankScore = ranked.get(s);
                    }
                    if (player.get(a) >= ranked.get(s))
                        break;
                }
            }

            if (s == ranked.size()) {
                results[a] = rank + 1;
            } else {
                results[a] = rank;
            }
        }

        List<Integer> response = new ArrayList<>();

        for (Integer element : results) {
            response.add(element);
        }


        return response;
    }
}