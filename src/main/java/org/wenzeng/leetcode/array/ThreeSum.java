package org.wenzeng.leetcode.array;

import org.wenzeng.leetcode.Utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wenzeng
 * @version : ThreeSum.java, v 0.1 2020年08月11日 20:43:47 wenzeng Exp $
 */
public class ThreeSum {

    /**
     * 思路：3Sum转化成2Sum
     * <p>
     * 1、排序
     * <p>
     * 2、a+b+c = 0 问题转换为 b+c = 0-a 问题
     * <p>
     * 3、重复匹配问题？咋整
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }
        // 1、排序（必须基于排序）
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        int target = 0;
        // 2、a+b+c = 0 问题转换为 b+c = 0-a 问题，通过三个指针left,mid,right
        // 3、其中 0-a 通过left控制
        int mid, right;
        for (int left = 0, len = nums.length; left < len && nums[left] <= target; left++) {
            mid = left + 1;
            right = len - 1;
            int tmp = target - nums[left];

            // left防止重复
            if (left > 0 && nums[left] == nums[left - 1]) {
                continue;
            }
            while (mid < right) {
                int tmpMid = nums[mid];

                int tmpRight = nums[right];
                // 2SUM
                if (tmpMid + tmpRight == tmp) {
                    list.add(Arrays.asList(nums[left], tmpMid, tmpRight));
                    //mid去重
                    while (mid < right && tmpMid == nums[mid + 1]) {
                        mid++;
                    }
                    // right去重
                    while (mid < right && right > 1 && tmpRight == nums[right - 1]) {
                        right--;
                    }
                }
                // 如果小于目标值,向右移动mid
                if (nums[mid] + nums[right] < tmp) {
                    mid++;
                }
                // 如果大于目标值,向做移动right
                else {
                    right--;
                }
            }
        }

        return list;

    }

    public static void main(String[] args) {

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums2 = new int[]{-2, -2, -1, -1, 0, 1, 1, 2, 2};

        Utils.print(threeSum(nums));
        Utils.print(threeSum(nums2));
    }

}
