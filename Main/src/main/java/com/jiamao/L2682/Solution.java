package com.jiamao.L2682;

import java.util.HashSet;
import java.util.Set;
    // set存储即可
public class Solution {
    public int[] circularGameLosers(int n, int k) {
        Set<Integer> set=new HashSet<>();
        int now=1,a=1;
        set.add(now);
        now=nextStep(now+k*a++,n);
        while (!set.contains(now)){
            set.add(now);
            now=nextStep(now+k*a++,n);
        }
        int[] res = new int[n - set.size()];
        int idx=0;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i))
                res[idx++]=i;
        }
        return res;
    }

    int nextStep(int now,int n){
        return now%n==0?n:now%n;
    }
}
