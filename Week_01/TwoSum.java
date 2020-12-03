package com.tj.kuan;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (null == nums || nums.length <2)return new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0; i< nums.length;i++){
            int oldKey = nums[i];
            if (map.containsKey(oldKey)){
                return new int[]{map.get(oldKey), i};
            } else {
                map.put(target - nums[i],i);
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {

    }
}
