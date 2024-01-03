package com.itheima.algorithm.recursion;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class E02HanoiTower {
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    static void init(int n) {
        for (int i = n; i >= 1; i--) {
            a.addLast(i);
        }
    }

    /**
     * Params: n-圆盘个数
     * a-源
     * b-借
     * C-目.
     *
     * @param n
     * @param a
     * @param b
     * @param c
     */
    static void move(int n, LinkedList<Integer> a,
                     LinkedList<Integer> b,
                     LinkedList<Integer> c) {
        if (n == 0) return;
        move(n - 1, a, c, b);
        c.addLast(a.removeLast());
        print();
        move(n - 1, b, a, c);
    }

    @Test
    public void test1() {
        init(3);
        print();
        move(3, a, b, c);
    }

    private static void print() {
        System.out.println("-----------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
