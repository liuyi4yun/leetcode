package org.wenzeng.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author wenzeng
 * @version : ArraySort.java, v 0.1 2020年08月10日 22:33:11 wenzeng Exp $
 */
public class Utils {

    /**
     * 数组排序(升序)
     *
     * @param array the array
     * @return the sorted array
     */
    public static int[] sort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int[] sortedArray = Arrays.copyOf(array, array.length);

        Arrays.sort(sortedArray);

        return sortedArray;
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void print(Object object) {
        System.out.println(object);
    }
}
