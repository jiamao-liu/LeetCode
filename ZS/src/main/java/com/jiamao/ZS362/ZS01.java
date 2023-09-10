package com.jiamao.ZS362;

import java.util.HashSet;
import java.util.List;

public class ZS01 {
    public int numberOfPoints(List<List<Integer>> nums) {
        HashSet<Integer> set=new HashSet<>();
        for (List<Integer> num : nums) {
            for (int i = num.get(0); i <= num.get(1); i++) {
                set.add(i);
            }
        }
        return set.size();
    }
}
