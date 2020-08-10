package org.wenzeng.leetcode.array;

import java.util.Arrays;

/**
 * Two Sum
 * <p>
 * 1、算法一
 * <p>
 * 2、
 *
 * @author wenzeng
 * @version : TwoSum.java, v 0.1 2020年08月10日 16:29:01 wenzeng Exp $
 */
public class TwoSum {

    /**
     * 暴力算法，二次循环
     * <p>
     * 时间复杂度：O(N*N)
     *
     * @param nums   the nums
     * @param target the target value
     * @return array index array
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        boolean hasTwoSum = false;
        int[] indexArray = new int[2];
        for (int i = 0, len = nums.length; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    indexArray[0] = i;
                    indexArray[j] = j;
                    hasTwoSum = true;
                    break;
                }
            }
        }
        return hasTwoSum ? indexArray : null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3, 4, 5, 6};
        System.out.println(Arrays.toString(twoSum(nums, 2)));
    }
}
