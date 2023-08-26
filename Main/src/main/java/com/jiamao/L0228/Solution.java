package com.jiamao.L0228;

import java.util.*;
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length==0)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        Integer start=null;
        Integer end=null;
        for (int i = 0; i < nums.length ; i++) {
            if (start==null){
                start=nums[i];
                end=start;
                continue;
            }
            if (nums[i]==end+1){
                end=nums[i];
            }
            else{
                result.add(start.equals(end)?""+start:start+"->"+end);
                start=nums[i];
                end=start;
            }
        }
        result.add(start.equals(end)?""+start:start+"->"+end);
        return result;
    }
}
