package com.jiamao.L0237;


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class Solution {
    public void deleteNode(ListNode node) {
        node.val= node.next.val;
        node.next=node.next.next;
    }
}
