package com.jiamao.L0313;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution {
    // primes= 1 3 5
    // 1 3 5 下一个数字就是 1 3 5 分别乘以135，其中大于5中最小的一个就是下一个结果
    // 上面的思路是暴力思路，

    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n==1)
            return 1;
        int res=1;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        for (int prime : primes) {
            set.add(prime);
            priorityQueue.offer(prime);
        }
        for (int i = 0; i < n - 1; i++) {
            res=priorityQueue.poll();
            for (int prime : primes) {
                if (1l*res*prime<Integer.MAX_VALUE&&!set.contains(res*prime)){
                    set.add(res*prime);
                    priorityQueue.offer(res*prime);
                }
            }
        }
        return res;
    }
    public int BLnthSuperUglyNumber(int n, int[] primes) {
        if (n==1)
            return 1;
        int res=1;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        for (int prime : primes) {
            set.add(prime);
            priorityQueue.offer(prime);
        }
        for (int i = 0; i < n - 1; i++) {
            res=priorityQueue.poll();
            for (int prime : primes) {
                if (1l*res*prime<Integer.MAX_VALUE&&!set.contains(res*prime)){
                    set.add(res*prime);
                    priorityQueue.offer(res*prime);
                }
            }
        }
        return res;
    }
}
