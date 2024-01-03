package com.itheima.algorithm.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class E06Fibonacci {

    /**
     * 递归求斐波那契第n项
     *
     * @param n
     * @return
     */
    private static int f(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int x = f(n - 1);
        int y = f(n - 2);
        return x + y;
    }

    @Test
    public void test1() {
        System.out.println(E06Fibonacci.f(8));
    }
}
