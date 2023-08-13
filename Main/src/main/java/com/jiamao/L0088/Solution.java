package com.jiamao.L0088;


// 如果从前开始，数组2插入的数据会导致数组1的数据往后挪
// 从后开始合并就没有这个问题
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx=nums1.length-1;
        m--;
        n--;
        while (idx>=0){
            if (m<0)
                nums1[idx--]=nums2[n--];
            else if (n<0)
                nums1[idx--]=nums1[m--];
            else if (nums1[m]<=nums2[n])
                nums1[idx--]=nums2[n--];
            else
                nums1[idx--]=nums1[m--];
        }
    }
}
