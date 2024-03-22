package com.itheima.job;

import java.util.Arrays;

public class charArraysUtils {
    private char[] charArray = {'a', 'c', 'd', 'k'};
    private int maxLen = 5;

    void arraysToString() {
        System.out.println(Arrays.toString(charArray));
    }

    void add(char key) {
        if (charArray == null || charArray.length >= maxLen) {
            return;
        }
        char[] newArrays = Arrays.copyOf(charArray, charArray.length + 1);
        newArrays[newArrays.length - 1] = key;
        charArray = newArrays;
    }

    Integer select(char key) {
        //双指针查找
        int left = 0, right = charArray.length - 1;
        while (left <= right) {
            if (charArray[left] == key) {
                return left;
            }
            if (charArray[right] == key) {
                return right;
            }
            left++;
            right--;
        }
        return null;
    }

    void delet(char key) {
        //不规范但可行
        if (charArray.length <= 0) {
            return;
        }
        char[] newChars = new char[charArray.length - 1];
        try {
            for (int i = 0, j = 0; i < charArray.length; i++) {
                if (charArray[i] == key) {
                    continue;
                }
                newChars[j++] = charArray[i];
            }
            charArray = newChars;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(key + "不存在,无法删除");
        }
    }

    void updata(char key, char tag) {
        if (select(key) == null) {
            System.out.println(key + "不存在，无法更新");
            return;
        }
        charArray[select(key)] = tag;
    }

    public static void main(String[] args) {
        charArraysUtils list = new charArraysUtils();
        list.add('y');
        list.arraysToString();
        list.add('p');
        list.arraysToString();
        System.out.println("索引为" + list.select('d'));
        System.out.println("索引为" + list.select('j'));
        list.delet('d');
        list.delet('d');
        list.arraysToString();
        list.updata('k', 'w');
        list.arraysToString();
        list.updata('k', 'w');
        list.arraysToString();

        list.delet('a');
        list.delet('c');
        list.delet('w');
        list.delet('y');
        list.arraysToString();
        list.delet('a');
        list.select('a');
        list.updata('a', 'b');
        list.add('a');
        list.arraysToString();
    }
}
