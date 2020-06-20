/*
两次遍历
 */

class Solution22_1 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        int n = 0;
        ListNode cur = head;

        while (cur != null) {
            n++;
            cur = cur.next;
        }

        cur = head;
        n -= k;

        while (n > 0) {
            cur = cur.next;
            n--;
        }

        return cur;
    }
}