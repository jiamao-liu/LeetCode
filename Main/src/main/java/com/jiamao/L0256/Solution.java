package com.jiamao.L0256;

public class Solution {
    public int minCost(int[][] costs) {
        int houseNum = costs.length;
        int[][] dp = new int[houseNum][3];
        dp[0]=costs[0];
        for (int i = 1; i < houseNum; i++) {
            dp[i][0]=costs[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=costs[i][1]+Math.min(dp[i-1][2],dp[i-1][0]);
            dp[i][2]=costs[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
        }
        return getLastLineMinNumber(dp);
    }
    private int getLastLineMinNumber(int[][] nums){
        int lastLine=nums.length-1;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < nums[0].length; i++)
            min=Math.min(min,nums[lastLine][i]);
        return min;
    }
}
