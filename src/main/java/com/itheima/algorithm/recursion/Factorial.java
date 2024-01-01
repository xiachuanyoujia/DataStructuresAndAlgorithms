package com.itheima.algorithm.recursion;

import org.junit.jupiter.api.Test;

public class Factorial {
    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        return n * f(n - 1);
    }

    @Test
    public void testF() {
        int f = f(5);
        System.out.println(f);
    }
}
