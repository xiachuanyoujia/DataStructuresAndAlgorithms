package com.itheima.job;

import java.util.Arrays;
import java.util.Scanner;

class insertIntoSortedArray {
    int[] arr = {1, 2, 5, 7, 9};
    int[] result;
    Scanner reader = new Scanner(System.in);

    void insertInt() {
        try {
            int num = reader.nextInt();
            result = new int[arr.length + 1];
            int i = 0;
            for (; i < arr.length; i++) {
                if (arr[i] > num) {
                    break;
                }
                result[i] = arr[i];
            }
            result[i] = num;
            for (; i < arr.length; i++) {
                result[i + 1] = arr[i];
            }
        } catch (Exception e) {
            System.out.println("输入的不是一个整数！");
        }
    }

    void resultToString() {
        System.out.println(Arrays.toString(result));
    }
}

public class Example {
    public static void main(String[] args) {
        insertIntoSortedArray array = new insertIntoSortedArray();
        array.insertInt();
        array.resultToString();
    }
}
