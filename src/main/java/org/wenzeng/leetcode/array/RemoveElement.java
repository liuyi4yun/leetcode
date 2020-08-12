package org.wenzeng.leetcode.array;

import org.wenzeng.leetcode.Utils;

/**
 * 27. 移除元素
 * <p>
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wenzeng
 * @version : RemoveElement.java, v 0.1 2020年08月12日 22:05:36 wenzeng Exp $
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        Utils.printArray(nums);

        return index;
    }

    /**
     * 通过左右指针移动
     * <p>
     * 0,1,2,2,3,0,4,2
     */
    public static int removeElement2(int[] nums, int val) {

        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] == val && nums[right] != val) {
                nums[left] = nums[right];
                nums[right] = val;
            }
            if (nums[left] != val) {
                left++;
            }
            if (nums[right] == val) {
                right--;
            }
        }
        Utils.printArray(nums);
        return right + 1;
    }

    public static void main(String[] args) {
        Utils.print(removeElement(new int[]{3, 2, 2, 3}, 3));
        Utils.print(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));

        Utils.print(removeElement2(new int[]{3, 2, 2, 3}, 3));
        Utils.print(removeElement2(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
