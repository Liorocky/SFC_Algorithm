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
    Map<Integer, Integer> pos;
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        this.preorder = preorder;

        pos = new HashMap<>(inLen);
        for (int i = 0; i < preLen; i++) {
            pos.put(inorder[i], i);
        }

        return buildTree(0, preLen - 1, 0, inLen - 1);
    }

    private TreeNode buildTree(int preL, int preR, int inL, int inR) {
        if (preL > preR || inL > inR) return null;

        int pivot = preorder[preL];
        TreeNode root = new TreeNode(pivot);

        int pivotIndex = pos.get(pivot);

        root.left = buildTree(preL + 1, pivotIndex - inL + preL, inL, pivotIndex - 1);
        root.right = buildTree(pivotIndex - inL + preL + 1, preR, pivotIndex + 1, inR);

        return root;
    }
}