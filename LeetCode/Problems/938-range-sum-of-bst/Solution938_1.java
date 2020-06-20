/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int sum;
    public int rangeSumBST(TreeNode root, int L, int R) {
        sum = 0;
        recur(root, L, R);
        return sum;
    }

    private void recur(TreeNode root, int L, int R) {
        if (root == null) return;
        if (root.val >= L && root.val <= R) sum += root.val;
        recur(root.left, L, R);
        recur(root.right, L, R);
    }
}