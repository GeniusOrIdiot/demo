package com.example.demo.java_code.leetcode.two_sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return null;
    }

    public int[] twoSum_1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i< nums.length; i++) {
            int num_2 = target - nums[i];
            if (map.containsKey(num_2)) return new int[]{i, map.get(num_2)};
            map.put(nums[i], i);
        }
        return null;
    }
}
