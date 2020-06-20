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
    List<Integer> list;
    public int minDiffInBST(TreeNode root) {
        list = new ArrayList<>();
        recur(root);
        Collections.sort(list);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            ans = Math.min(ans, list.get(i + 1) - list.get(i));
        }

        return ans;
    }

    private void recur(TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        recur(root.left);
        recur(root.right);
    }
}