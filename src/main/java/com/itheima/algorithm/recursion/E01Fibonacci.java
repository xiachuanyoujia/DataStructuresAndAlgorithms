package com.itheima.algorithm.recursion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class E01Fibonacci {

    /**
     * 使用Memoization(记忆法,也称备忘录)改进
     * Params: n-第n项
     * Returns:第n项的值
     *
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return f(n, cache);
    }

    /**
     * 递归求斐波那契第n项   记忆法
     *
     * @param n
     * @return
     */
    private static int f(int n, int[] cache) {
        if (cache[n] != -1) {
            return cache[n];
        }

        int x = f(n - 1, cache);
        int y = f(n - 2, cache);
        cache[n] = x + y;
        return cache[n];
    }


    @Test
    public void test1() {
        assertEquals(1, fibonacci(2));
        assertEquals(2, fibonacci(3));
        assertEquals(3, fibonacci(4));
        assertEquals(5, fibonacci(5));
        assertEquals(8, fibonacci(6));
        assertEquals(13, fibonacci(7));
    }
}
