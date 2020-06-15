public class BinarySearchTree {

    /**
     * 节点内部类
     */
    private static class BinaryNode {
        int val; // 值
        BinaryNode left; // 左节点
        BinaryNode right; // 右节点

        BinaryNode(int val) {
            this.val = val;
        }

        BinaryNode(int val, BinaryNode left, BinaryNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        /**
         * 前序遍历
         *
         * @param t 开始遍历的节点
         */
        private void preOrder(BinaryNode t) {
            if (t != null) {
                System.out.println(t.val);
                preOrder(t.left);
                preOrder(t.right);
            }
        }

        /**
         * 中序遍历
         *
         * @param t 开始遍历的节点
         */
        private void infixOrder(BinaryNode t) {
            if (t != null) {
                infixOrder(t.left);
                System.out.println(t.val);
                infixOrder(t.right);
            }
        }

        /**
         * 后序遍历
         *
         * @param t 开始遍历的节点
         */
        private void postOrder(BinaryNode t) {
            if (t != null) {
                postOrder(t.left);
                postOrder(t.right);
                System.out.println(t.val);
            }
        }
    }

    /**
     * 根节点，初始化为null
     */
    private BinaryNode root;

    /**
     * 构造方法
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * 格式化二叉树
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * 判树是否为空
     *
     * @return true为空 false不为空
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 是否有值为x的节点
     *
     * @param x 查询节点的值
     * @return 有为true 否则为false
     */
    public boolean contains(int x) {
        return contains(x, root);
    }


    /**
     * 插入新节点
     *
     * @param x 新节点的值
     */
    public void insert(int x) {
        root = insert(x, root);
    }

    /**
     * 根据值移除元素
     *
     * @param x 待移除元素的值
     */
    public void remove(int x) {
        root = remove(x, root);
    }

    /**
     * 查询树中的最小值
     *
     * @return 最小值
     */
    public int findMin() {
        if (isEmpty()) {
            throw new NullPointerException("无法遍历，当前树为空");
        }

        return findMin(root).val;
    }

    /**
     * 查询树中的最大值
     *
     * @return 最大值
     */
    public int findMax() {
        if (isEmpty()) {
            throw new NullPointerException("无法遍历，当前树为空");
        }

        return findMax(root).val;
    }

    /**
     * 遍历打印树 默认为前序遍历
     *
     * @param k 0前序  1中序  2后序
     */
    public void printTree(int k) {
        if (isEmpty()) {
            throw new NullPointerException("无法遍历，当前树为空");
        } else {
            switch (k) {
                case 1:
                    root.infixOrder(root);
                    break;
                case 2:
                    root.postOrder(root);
                    break;
                default:
                    root.preOrder(root);
            }
        }
    }

    /**
     * 是否有值为x的节点
     *
     * @param x 查询节点的值
     * @param t 起始节点
     * @return 匹配到为true，否则为false
     */
    private boolean contains(int x, BinaryNode t) {
        if (t == null) {
            return false; // 遍历完了也没有查到
        }

        if (x < t.val) {
            return contains(x, t.left); // 在左子树递归查询
        } else if (x > t.val) {
            return contains(x, t.right); // 在右子树递归查询
        } else {
            return true; // 匹配到了
        }
    }

    /**
     * 插入新节点
     *
     * @param x 新节点的值
     * @param t 起始节点
     * @return 如果插入成功 返回插入后的节点，否则返回节点 t
     */
    private BinaryNode insert(int x, BinaryNode t) {
        // 如果被插入的节点为空，则直接创建新节点，值为x
        if (t == null) {
            return new BinaryNode(x, null, null);
        }

        if (x < t.val) {
            // x小于当前节点的值，说明要插入到左子树中
            t.left = insert(x, t.left);
        } else if (x > t.val) {
            // x大于当前节点的值，说明要插入到右子树中
            t.right = insert(x, t.right);
        } else {
            // 没有找到，直接返回t，这一段不写也可以
            return t;
        }

        return t;
    }

    /**
     * 具体实现
     * 根据值移除元素
     *
     * @param x 待移除元素的值
     * @param t 从哪个节点开始执行
     * @return 待移除元素右子树中的最小子节点
     */
    private BinaryNode remove(int x, BinaryNode t) {
        if (t == null) return t; // 节点为空

        if (x < t.val) {
            /*
             * 如果 x 小于当前节点的值，说明待删除节点可能在左树，不可能在右树
             * 左递归删除
             */
            t.left = remove(x, t.left);
        } else if (x > t.val) {
            /*
             * 如果 x 大于当前节点的值，说明待删除节点可能在右树，不可能在左树
             * 右递归删除
             */
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {
            /*
             * x等于当前节点的值，并且当前节点有左右子树
             * 需要使用特殊的removeMin方法，进行树的旋转
             * 详见removeMin方法
             */
//            t.val = findMin(t.right).val;
//            t.right = remove(t.val, t.right);
            removeMin(t); // 效率高一些
        } else {
            /*
             * x等于当前节点的值，但当前节点只有左子树或者右子树
             * 返回不为null的那个子树
             */
            t = (t.left != null) ? t.left : t.right;
        }

        return t;
    }

    /**
     * 特殊的 removeMin 方法
     * 将 t 节点的值替换为右节点中最小节点的值，并删除右节点中的最小节点
     * 即删除节点 t ，并旋转树
     *
     * @param t 待删除节点
     */
    private void removeMin(BinaryNode t) {
        if (t == null) return; // 如果待删除节点为空，则直接返回。

        BinaryNode n = t.right; // 从右侧开始删除
        BinaryNode p = null; // 保存最小节点的父节点

        while (true) {
            if (n.left != null) {
                // 表示不是最小节点，继续遍历
                p = n;
                n = n.left;
            } else {
                /*
                 * 找到最小节点
                 * 此时将最小节点的值给予待删除节点（树的旋转）
                 * 最小节点的父节点的左节点指向最小节点的右节点（可能为 null）
                 */
                t.val = n.val;
                p.left = n.right;
                break;
            }
        }
    }


    /**
     * 递归返回最小节点
     *
     * @param t 起始节点
     * @return 返回最小节点
     */
    private BinaryNode findMin(BinaryNode t) {
        if (t == null) {
            return null; // 起始节点为空
        } else if (t.left == null) {
            return t; // 找到最小节点
        }
        return findMin(t.left); // 没有找到最小节点，左递归遍历
    }


    /**
     * 递归返回最大节点
     *
     * @param t 起始节点
     * @return 返回最大节点
     */
    private BinaryNode findMax(BinaryNode t) {
        if (t == null) {
            return null; // 起始节点为空
        } else if (t.right == null) {
            return t; // 找到最大节点
        }
        return findMax(t.right); // 没有找到最大节点，右递归遍历
    }


}

