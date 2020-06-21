/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
1. 遍历链表，找到相应的值
然后将上一个节点的next的next指向该节点的next
所以需要两个指针

如果没有找到相应的值，则返回原链表


*/

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;
        if (head.val == val) return head.next;

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                return head;
            }
            cur = cur.next;
            pre = pre.next;
        }

        return head;
    }
}