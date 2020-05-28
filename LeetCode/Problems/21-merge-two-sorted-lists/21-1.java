/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tempL1 = l1;
        ListNode tempL2 = l2;
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;

        while (tempL1 != null || tempL2 != null) {
            if (tempL1 == null) {
                cur.next = tempL2;
                break;
            }

            if (tempL2 == null) {
                cur.next = tempL1;
                break;
            }

            if (tempL1.val <= tempL2.val) {
                cur.next = tempL1;
                cur = cur.next;
                tempL1 = tempL1.next;
            } else {
                cur.next = tempL2;
                cur = cur.next;
                tempL2 = tempL2.next;
            }
        }

        return newHead.next;
    }
}