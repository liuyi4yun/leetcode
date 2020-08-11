package org.wenzeng.leetcode.array;

import org.wenzeng.leetcode.Utils;

import java.util.Arrays;

/**
 * Remove Duplicates from Sorted Array
 * <p>
 * 数组的in place(就地)交换一般得用双指针，不然数组中添加或删除一个元素，需要移动大量 元素。
 * 这时候，一般是一个指针遍历，一个指针去找可以用来交换的元素。
 *
 * @author wenzeng
 * @version : RemoveDuplicatesInArray.java, v 0.1 2020年08月10日 22:12:37 wenzeng Exp $
 */
public class RemoveDuplicatesInArray {

    /**
     * 移除排序数组中的重复元素，双指针
     * <p>
     * 1、一个指针遍历数组
     * 2、一个指针记录不重复数
     * <p>
     * eg: [1,1,2] =>[1,2,2]
     *
     * @param nums the array
     * @return the array which removed duplicate element
     */
    public static int[] removeDuplicate2(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return nums;
        }
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return nums;
    }

    /**
     * [1,1,1,2,2,3] => [1,1,2,2,3]
     *
     * @param nums the array
     * @return the array which removed duplicate element
     */
    public static int[] removeDuplicate3(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return nums;
        }
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[i - 2]) {
                nums[index++] = nums[i];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Utils.printArray(removeDuplicate2(Utils.sort(new int[]{1, 1, 2})));
        Utils.printArray(removeDuplicate3(Utils.sort(new int[]{1, 1, 1, 2, 2, 3})));
    }

}
