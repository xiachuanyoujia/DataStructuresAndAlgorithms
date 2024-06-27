package com.itheima.array;

import org.junit.jupiter.api.Test;

public class arrayTest {
    /**
     * 59. 螺旋矩阵 II
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int count = 1, target = n * n;
        int[][] res = new int[n][n];
        while (count <= target) {
            for (int j = l; j <= r; j++)
                res[t][j] = count++;
            t++;
            for (int i = t; i <= b; i++)
                res[i][r] = count++;
            r--;
            for (int j = r; j >= l; j--)
                res[b][j] = count++;
            b--;
            for (int i = b; i >= t; i--)
                res[i][l] = count++;
            l++;
        }
        return res;
    }

    @Test
    public void generateMatrixTest() {
        generateMatrix(5);
    }
}
