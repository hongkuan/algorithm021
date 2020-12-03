package com.tj.kuan;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length < 2) return;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                if (i != j) nums[j] = 0;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
