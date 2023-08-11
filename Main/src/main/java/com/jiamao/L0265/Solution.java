package com.jiamao.L0265;

// 提示1：动态规划
// 提示2：根据上一个房子计算当前房子

public class Solution {
    public int minCostII(int[][] costs) {
        int houseNum = costs.length;
        for (int i = 1; i < houseNum; i++) {
            int[] twoMinIndex = getTwoMinIndex(costs[i-1]);
            for (int j = 0; j < costs[0].length; j++)
                costs[i][j]+=j==twoMinIndex[0]?costs[i-1][twoMinIndex[1]]:costs[i-1][twoMinIndex[0]];
        }
        return getLastLineMinNumber(costs);
    }
    private int[] getTwoMinIndex(int[] nums){
        int minIdx=0;
        for (int i = 1; i < nums.length; i++)
            if (nums[i]<nums[minIdx])
                minIdx=i;
        int minIdx2=minIdx==0?1:0;
        for (int i = 1; i < nums.length; i++)
            if (i!=minIdx&&nums[i]<nums[minIdx2])
                minIdx2=i;
        return new int[]{minIdx,minIdx2};
    }
    private int getLastLineMinNumber(int[][] nums){
        int lastLine=nums.length-1;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < nums[0].length; i++)
            min=Math.min(min,nums[lastLine][i]);
        return min;
    }
}