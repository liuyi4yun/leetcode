package org.wenzeng.leetcode.array;

import org.wenzeng.leetcode.Utils;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * <p>
 * 输出：49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wenzeng
 * @version : ContainerWithMostWater.java, v 0.1 2020年08月11日 23:01:39 wenzeng Exp $
 */
public class ContainerWithMostWater {

    /**
     * 问题，在数据类找到两个点,使得 min(heights[left],heights[right])*(right-left)最大
     * <p>
     * 双指针
     */
    public static Integer maxArea(int[] heights) {
        if (heights == null || heights.length < 2) {
            return null;
        }
        int left = 0, right = heights.length - 1;
        int vol = vol(heights, left, right);
        int max_vol = vol;
        while (left < right) {
            // 找出最大的
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
            vol = vol(heights, left, right);

            if (vol > max_vol) {
                max_vol = vol;
            }
        }
        return max_vol;
    }

    public static int vol(int[] nums, int left, int right) {
        return Math.min(nums[left], nums[right]) * (Math.abs(left - right));
    }

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Utils.print(maxArea(nums));
    }
}
