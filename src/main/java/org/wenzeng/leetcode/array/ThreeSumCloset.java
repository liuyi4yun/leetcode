package org.wenzeng.leetcode.array;

import javafx.scene.effect.Effect;

import java.util.Arrays;
import java.util.Map;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wenzeng
 * @version : ThreeSumCloset.java, v 0.1 2020年08月11日 22:21:09 wenzeng Exp $
 */
public class ThreeSumCloset {

    /**
     * 3Sum解法思路
     * <p>
     * 1、排序
     * <p>
     * 2、如果等于target则返回
     * <p>
     * 3、假定最小值为
     */
    public static Integer threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);

        int mid, right;

        //假定一个最小值
        int min = nums[0] + nums[1] + nums[2];

        // a + b + c ~ target  - > b + c ~ target - a
        for (int left = 0; left < nums.length - 2; left++) {
            mid = left + 1;
            right = nums.length - 1;
            int tmp = target - nums[left];

            while (mid < right) {
                //如何找出最接近的值
                if (Math.abs(target - (nums[left] + nums[mid] + nums[right])) < Math.abs(target - min)) {
                    min = nums[left] + nums[mid] + nums[right];
                }
                // 刚好相等，直接返回
                if (nums[left] + nums[right] == tmp) {
                    return target;
                }
                if (nums[mid] + nums[right] < target) {
                    mid++;
                } else {
                    right--;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }
}
