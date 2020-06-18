/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ArrayList<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private void recur(ListNode head) {
        if (head == null) return;
        recur(head.next);
        list.add(head.val);
    }
}