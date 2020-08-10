package org.wenzeng.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 * <p>
 * 算法菜鸡入门
 * <p>
 * 方法1:暴力，复杂度O(n2)，会超时
 * <p>
 * 方法2:hash，用一个哈希表，存储每个数对应的下标，复杂度 O(n) .
 * <p>
 * 方法3:先排序，然后左右夹逼，排序O(nlogn)，左右夹逼 O(n) ，最终O(nlogn)。
 *
 * @author wenzeng
 * @version : TwoSum.java, v 0.1 2020年08月10日 16:29:01 wenzeng Exp $
 */
public class TwoSum {

    /**
     * 暴力算法
     * <p>
     * 暴力，复杂度O(n2)
     *
     * @param nums   the array nums
     * @param target the target value
     * @return index value array
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
                    indexArray[1] = j;
                    hasTwoSum = true;
                    break;
                }
            }
        }
        return hasTwoSum ? indexArray : null;
    }

    /**
     * hash，用一个哈希表，存储每个数对应的下标，复杂度 O(n)，最优
     *
     * @param nums   the array nums
     * @param target the target value
     * @return index value array
     */
    public static int[] twoSumHash(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }

        Map<Integer/*array element*/, Integer/*array index*/> eleToIdxMap = new HashMap<>(nums.length);

        for (int i = 0, len = nums.length; i < len; i++) {
            eleToIdxMap.put(nums[i], i);
        }

        boolean hasTwoSum = false;
        int[] indexArray = new int[2];

        for (int i = 0, len = nums.length; i < len; i++) {

            int rest = target - nums[i];

            Integer anotherIndex = eleToIdxMap.get(rest);
            // 不为空,向后不重复
            if (anotherIndex != null && anotherIndex > i) {
                indexArray[0] = i;
                indexArray[1] = anotherIndex;
                hasTwoSum = true;
            }
        }
        return hasTwoSum ? indexArray : null;
    }


    /**
     * 先排序，然后左右夹逼，排序O(nlogn)，左右夹逼 O(n) ，最终O(nlogn)。
     *
     * @param nums   the array nums
     * @param target the target value
     * @return index value array
     */
    public static int[] twoSumSorted(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        // 拷贝
        int[] sorted_nums = Arrays.copyOf(nums, nums.length);

        // 升序
        Arrays.sort(sorted_nums);

        // 左右夹逼
        int start = 0;
        int end = sorted_nums.length;

        while (start < end) {

            //右方向逼近
            while (sorted_nums[start] + sorted_nums[--end] > target) {
                System.out.println(String.format("R2L:start:%s,StartVal:%s,end:%s,EndVal:%s",
                        start, sorted_nums[start], end, sorted_nums[end]));
            }
            if (sorted_nums[start] + sorted_nums[end] == target) {
                break;
            }
            // 左方向逼近
            while (sorted_nums[++start] + sorted_nums[end] < target) {
                System.out.println(String.format("R2L:start:%s,StartVal:%s,end:%s,EndVal:%s",
                        start, sorted_nums[start], end, sorted_nums[end]));
            }
            if (sorted_nums[start] + sorted_nums[end] == target) {
                break;
            }
        }
        boolean hasTwoSum = false;
        int[] indexArray = new int[2];
        int index = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] == sorted_nums[start] || nums[i] == sorted_nums[end]) {
                indexArray[index++] = i;
                hasTwoSum = true;
            }
        }
        return hasTwoSum ? indexArray : null;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3, 5, 4, 6, 2};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
        System.out.println(Arrays.toString(twoSumHash(nums, 9)));
        System.out.println(Arrays.toString(twoSumSorted(nums, 9)));
    }
}
