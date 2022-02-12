package com.company.targetsum;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 6, 10};
        int targetSum = 8;

        Arrays.sort(nums);
        int[] ints = targetSumCounter(nums, targetSum);

        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

    // вернуть числа, сумма которых равна targetSum.
    public static int[] targetSumCounter(int[] nums, int targetSum) {
        int[] resp = new int[nums.length];
        int minus = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == targetSum) {
                resp = new int[1];
                resp[0] = nums[i];
                return resp;
            }

            if ((nums[i] < targetSum - minus) && (targetSum - minus) >= 0) {
                resp[i] = nums[i];
                minus = nums[i];
            }

        }

        return resp;
    }

}
