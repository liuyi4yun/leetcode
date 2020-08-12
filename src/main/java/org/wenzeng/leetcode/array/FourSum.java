package org.wenzeng.leetcode.array;

import org.wenzeng.leetcode.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wenzeng
 * @version : FourSum.java, v 0.1 2020年08月11日 22:54:11 wenzeng Exp $
 */
public class FourSum {

    /**
     * 4SUM问题转化为3SUM问题
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return null;
        }
        Arrays.sort(nums);

        List<List<Integer>> ret = new ArrayList<>();

        // a + b + c + d = target => b + c + d = target -  a
        int mid, right;
        for (int i = 0, len = nums.length; i < len - 3; i++) {
            int target_i = target - nums[i];
            //过滤重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int left = i + 1; left < len - 2; left++) {
                mid = left + 1;
                right = len - 1;
                int tmp = target_i - nums[left];
                while (mid < right) {

                    if (nums[mid] + nums[right] == tmp) {
                        ret.add(Arrays.asList(nums[i], nums[left], nums[mid], nums[right]));

                        while (mid < right && nums[mid] == nums[mid + 1]) {
                            mid++;
                        }
                        while (mid < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                    }
                    if (nums[mid] + nums[right] < tmp) {
                        mid++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        Utils.print(fourSum(nums, 0));
    }
}
