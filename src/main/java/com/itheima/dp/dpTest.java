package com.itheima.dp;

import org.junit.jupiter.api.Test;

public class dpTest {

    /**
     * 343. 整数拆分
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i=3;i<=n;i++){
            for(int j=1;j<=i-j;j++){
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        System.out.println(dp);
        return dp[n];
    }

    @Test
    public void testIntegerBreak() {
        integerBreak(4);
    }

    /**
     * 63. 不同路径 II
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = (obstacleGrid[0][0] == 1) ? 0 : 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i][0] == 1 || dp[i - 1][0] == 0) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[0][i] == 1 || dp[0][i - 1] == 0) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    @Test
    public void testUniquePathsWithObstacles() {
        int[][] obstacleGrid = {
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0}
        };
        uniquePathsWithObstacles(obstacleGrid);
    }

    /**
     * 62. 不同路径
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                System.out.println(dp[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void testUniquePaths() {
        uniquePaths(3, 7);
    }

    /**
     * LCR 088. 使用最小花费爬楼梯
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    @Test
    public void testMinCostClimbingStairs() {
        dpTest solution = new dpTest();
        int[] cost2 = {1, 2, 3, 4, 5};
        solution.minCostClimbingStairs(cost2);
    }
}
