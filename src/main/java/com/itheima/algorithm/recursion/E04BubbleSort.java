package com.itheima.algorithm.recursion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 递归冒泡排序
 * ●将数组划分成两部分[0 .. j] [j+1.. a.length-1]
 * ●左边[0..j]未排序部分
 * ●右边[j+1 .. a.length-1]是已排序部分
 * ●未排序区间内,相邻的两个元素比较,如果前一个大于后一个,则交换位置
 */
public class E04BubbleSort {

    public static void sort(int[] a) {
        bubble(a, a.length - 1);
    }

    //j代表未排序区域右边界
    private static void bubble(int[] a, int j) {
        if (j == 0) {
            return;
        }

        for (int i = 0; i < j; i++) {
            if (a[i] > a[i + 1]) {
                int t = a[i];
                a[i] = a[i + 1];
                a[i + 1] = t;
            }
        }
        bubble(a, j - 1);
    }

    @Test
    public void test1() {
        int[] a = {7, 13, 30, 38, 53, 34, 52, 21};
        System.out.println(Arrays.toString(a));
        E04BubbleSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
