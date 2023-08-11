package com.jiamao.L0276;

public class Solution {
    public int numWays(int n, int k) {
        if (n==1)
            return k;
        int one=k;
        int two=0;
        int sum=one+two;
        for (int i = 1; i < n; i++) {
            int newOne=two*(k-1)+one*(k-1);
            int newTwo=one;
            sum=newOne+newTwo;
            one=newOne;
            two=newTwo;
        }
        return sum;
    }
}