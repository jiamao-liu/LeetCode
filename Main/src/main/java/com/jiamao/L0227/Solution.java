package com.jiamao.L0227;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
    public int calculate(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i)!=' ')
                stringBuilder.append(s.charAt(i));
        s=stringBuilder.toString();
        String[] strs = s.split("[+-]");
        List<Boolean> tags = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='+')
                tags.add(true);
            else if (s.charAt(i)=='-')
                tags.add(false);
        }
        int res=count(strs[0]);
        for (int i = 0; i < tags.size(); i++)
            res+=tags.get(i)?count(strs[i+1]):-count(strs[i+1]);
        return res;
    }

    int count(String s){
        String[] strs = s.split("[*/]");
        List<Boolean> tags = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='*')
                tags.add(true);
            else if (s.charAt(i)=='/')
                tags.add(false);
        }
        int res = Integer.parseInt(strs[0]);
        for (int i = 0; i < tags.size(); i++)
            res=tags.get(i)?res*Integer.parseInt(strs[i + 1]): res/Integer.parseInt(strs[i + 1]);
        return res;
    }
}
