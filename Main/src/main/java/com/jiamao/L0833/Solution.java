package com.jiamao.L0833;

import java.util.Arrays;

// 本题不存在重叠的情况
// 从前往后替换会导致index发生变化，从后就不会

public class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int len =indices.length;
        Transfer[] data=new Transfer[len];
        for (int i = 0; i < len; i++)
            data[i]=new Transfer(indices[i],sources[i],targets[i]);
        Arrays.sort(data, (a,b)->b.index-a.index);
        for (Transfer tran : data) {
            if (tran.index+tran.source.length()<=s.length()
                    &&s.substring(tran.index, tran.index+tran.source.length()).equals(tran.source))
                s=s.substring(0,tran.index)+tran.target+s.substring(tran.index+tran.source.length());
        }
        return s;
    }
}
class Transfer{
    int index;
    String source;
    String target;
    public Transfer(int index, String source, String target) {
        this.index = index;
        this.source = source;
        this.target = target;
    }
}