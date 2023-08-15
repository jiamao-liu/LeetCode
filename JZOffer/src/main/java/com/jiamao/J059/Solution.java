package com.jiamao.J059;

import java.util.Deque;
import java.util.LinkedList;


// https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/description/
// 暴力解法的时间复杂度是(n-k)k
// 问题的关键就在于如何快速计算出滑动窗口内的最大值
// 比较朴素的方案就是利用 大根堆 来处理，Java优先队列就是大根堆的实现方式之一，时间复杂度是nlogk
// 因为这里的窗口的的数据新增和淘汰是顺序的，所以不需要像大根堆那样严格的排序，只需要知道他的不严格单调递减序列即可
public class Solution {

    Deque<Integer> stack;
    public int[] maxSlidingWindow(int[] nums, int k) {
        stack=new LinkedList<>();
        int fast=0,slow=0;
        for (int i = 0; i < k; i++) {
            push(nums[fast++]);
        }
        int[] res = new int[nums.length - k + 1];
        res[slow]=stack.getLast();
        while (fast< nums.length){
            push(nums[fast++]);
            if (stack.getLast()==nums[slow++])
                stack.removeLast();
            res[slow]=stack.getLast();
        }
        return res;
    }
    void push(int val){
        while (!stack.isEmpty()&&stack.getFirst()<val)
            stack.removeFirst();
        stack.addFirst(val);
    }

}
