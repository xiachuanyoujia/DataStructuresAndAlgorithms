package com.itheima.algorithm.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class E03BinarySearch {

    public static int search(int[] a, int target) {
        return f(a, target, 0, a.length - 1);
    }

    /**
     * 递归(子问题)函数
     * Params: a -数组
     * target -待查找值
     * i -起始索引(包含)
     * j -结束索引包含)
     * Returns:
     * 找到返回索引
     * 找不到返回-1
     *
     * @param a
     * @param target
     * @param i
     * @param j
     * @return
     */
    private static int f(int[] a, int target, int i, int j) {
        if (i > j) {
            return -1;
        }

        int m = (i + j) >>> 1;
        if (target < a[m]) {
            return f(a, target, i, j - 1);
        } else if (a[m] < target) {
            return f(a, target, i + 1, j);
        } else {
            return m;
        }
    }

    @Test
    public void test1() {
        int[] a = {7, 13, 21, 30, 38, 43, 52, 53};
        assertEquals(0, search(a, 7));
        assertEquals(1, search(a, 13));
        assertEquals(4, search(a, 38));

    }
}
