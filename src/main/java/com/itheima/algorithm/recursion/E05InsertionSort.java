package com.itheima.algorithm.recursion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class E05InsertionSort {

    public static void sort(int[] a) {
        insertion(a, 1);
    }

    //j代表未排序区域右边界
    private static void insertion(int[] a, int low) {
        if (low == a.length) {
            return;
        }

        int t = a[low];
        int i = low - 1;

        while (i >= 0 && a[i] > t) {
            a[i + 1] = a[i];
            i--;
        }

        if (i + 1 != low) {
            a[i + 1] = t;
        }

        insertion(a, low + 1);
    }

    @Test
    public void test1() {
        int[] unsortedArray = {5, 3, 1, 4, 2};
        int[] expectedArray = {1, 2, 3, 4, 5};

        E05InsertionSort.sort(unsortedArray);

        assertArrayEquals(expectedArray, unsortedArray);
    }
}
