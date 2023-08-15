package com.jiamao.J060;

// https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/
// 这道题虽然骰子少，但是指数级的概率很难暴力解
// 提示：动态规划，模拟一个一个的掷骰子

import java.util.Arrays;

public class Solution {
    public double[] dicesProbability(int n) {
        double[][] dp = new double[2][n * 6 + 1];
        for (int i = 1; i <= 6; i++)
            dp[0][i]=1.0/6.0;
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < dp[0].length; j++)
                calPoint(dp,j);

            dp[0]=dp[1];
            dp[1]=new double[n * 6 + 1];
        }
        return Arrays.copyOfRange(dp[0],n,n * 6 + 1);
    }
    void  calPoint(double[][] dp,int now){
        for (int k = 1; k <= 6; k++) {
            if (now-k>0)
                dp[1][now]+=dp[0][now-k]/6.0;
        }
    }
}
