/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution297_1 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder("["); // 拼接的字符串

        Queue<TreeNode> queue = new LinkedList(); // 保存节点队列
        queue.add(root); // 先从根节点开始

        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove(); // 出队首节点
            if (cur == null) {
                /*
                如果节点为空，说明没有子节点，直接拼接null到字符串中
                 */
                res.append("null,");
            } else {
                /*
                节点不为空，则将值加入字符串中
                并且将其左右节点加入队列中
                 */
                res.append(cur.val + ",");
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }

        res.setLength(res.length() - 1); // 此时res中的值最后会多一个逗号，所以需要去掉最后一个字符
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 将字符串截取并分割，返回字符串数组，数组中的每一项都是一个节点值
        String[] arr = data.substring(1, data.length() - 1).split(",");

        Queue<TreeNode> queue = new LinkedList<>(); // 存储尚未找到子节点的父节点
        TreeNode root = getNode(arr[0]); // 保存数组第一个节点，最终返回它
        TreeNode parent = root; // 临时的父节点变量
        boolean isLeft = true; // 判断是否已经找到了左右子节点

        for (int i = 1; i < arr.length; i++) {
            TreeNode cur = getNode(arr[i]); // 遍历数组

            if (isLeft) {
                // 说明cur是parent的左节点
                parent.left = cur;
            } else {
                // 说明cur是parent的右节点
                parent.right = cur;
            }

            if (cur != null) {
                // 说明cur是一个父节点，但其左右子节点可能为空
                queue.add(cur);
            }

            isLeft = !isLeft; // 取反

            if (isLeft) {
                /*
                 如果此时为真，说明上面的cur是右节点，左右节点已经找到
                 队首出列，保存为新的父节点
                 */
                parent = queue.poll();
            }
        }

        return root;
    }

    /**
     * 返回以val为值的节点
     * @param val 如果val为"null"，则返回null
     * @return 返回以val为值的节点
     */
    private TreeNode getNode(String val) {
        if (val.equals("null")) {
            return null;
        }

        return new TreeNode(Integer.valueOf(val));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));