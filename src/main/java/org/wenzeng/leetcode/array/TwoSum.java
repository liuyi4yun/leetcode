package org.wenzeng.leetcode.array;

import java.util.Arrays;

/**
 * @author wenzeng
 * @version : TwoSum.java, v 0.1 2020年08月10日 16:29:01 wenzeng Exp $
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        int[] indexArray = new int[2];

        boolean hasTwoSum = false;

        for (int i = 0, len = nums.length; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    indexArray[0] = i;
                    indexArray[j] = j;
                    hasTwoSum = true;
                }
            }
        }
        return hasTwoSum ? indexArray : null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(twoSum(nums, 7)));
    }
}
