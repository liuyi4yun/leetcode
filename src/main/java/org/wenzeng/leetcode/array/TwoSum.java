package org.wenzeng.leetcode.array;

import org.wenzeng.leetcode.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wenzeng
 * @version : TwoSum.java, v 0.1 2020年08月11日 20:44:57 wenzeng Exp $
 */
public class TwoSum {

    /**
     * 暴力解法
     * <p>
     * 两次循环
     * <p>
     * 时间复杂度：O(N^2)
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        // 1、两次循环
        for (int i = 0, len = nums.length; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 排序+双指针解法
     * <p>
     * 1、排序
     * <p>
     * 2、双指针左右方向扫描
     * <p>
     * 时间复杂度： O(nlog(n))
     */
    public static int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        // 1、拷贝出一个新数组
        int[] sortedNums = Arrays.copyOf(nums, nums.length);

        // 2、从小到大排序 Dual-Pivot Quick Sort O(n log(n))
        Arrays.sort(sortedNums);

        // 3、定义左右指针，
        int start = 0;
        int end = sortedNums.length;

        while (start < end) {
            // 从右往左
            while (sortedNums[start] + sortedNums[--end] > target) {
            }
            if (sortedNums[start] + sortedNums[end] == target) {
                break;
            }

            // 从左到右
            while (sortedNums[start++] + sortedNums[end] < target) {

            }
            if (sortedNums[start] + sortedNums[end] == target) {
                break;
            }
        }
        int[] ret = new int[2];
        int index = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] == sortedNums[start] || nums[i] == sortedNums[end]) {
                ret[index++] = i;
            }
        }
        return ret;
    }

    /**
     * 借助HashMap,空间换时间
     * <p>
     * 时间复杂度： O(N)
     */
    public static int[] twoSum3(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        Map<Integer, Integer> ele2IdxMap = new HashMap<>(nums.length);

        for (int i = 0, len = nums.length; i < len; i++) {
            ele2IdxMap.put(nums[i], i);
        }

        for (int i = 0, len = nums.length; i < len; i++) {

            Integer restIndex = ele2IdxMap.get(target - nums[i]);

            if (restIndex != null && restIndex != i) {
                return new int[]{i, restIndex};
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        Utils.printArray(twoSum(nums, target));
        Utils.printArray(twoSum2(nums, target));
        Utils.printArray(twoSum3(nums, target));
    }
}
