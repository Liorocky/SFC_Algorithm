/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
2. 栈
*/

class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        ListNode resHead = new ListNode(0);
        ListNode resCur = resHead;
        while (!stack.empty()) {
            ListNode tmp = stack.pop();
            tmp.next = null;
            resCur.next = tmp;
            resCur = resCur.next;
        }
        return resHead.next;
    }
}