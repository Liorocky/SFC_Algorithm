public class BinaryTree {
    public static void main(final String[] args) {
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        myBinaryTree.setRoot(root);

        // 测试前序遍历
        System.out.println("前序遍历：");
        myBinaryTree.preOrder();

        // 测试中序遍历
        System.out.println("中序遍历：");
        myBinaryTree.infixOrder();

        // 测试后序遍历
        System.out.println("后序遍历：");
        myBinaryTree.postOrder();

        // 测试前序查找
        System.out.println("前序查找：");
        System.out.println(myBinaryTree.preOrderSearch(5).toString());

        // 测试删除
        System.out.println("删除3之前");
        myBinaryTree.preOrder();
        myBinaryTree.delNode(3);
        System.out.println("删除3之后");
        myBinaryTree.preOrder();
    }
}

// 定义二叉树
class MyBinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    // 前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    // 后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    // 前序查找
    public HeroNode preOrderSearch(int no) {
        if (this.root != null) {
            return this.root.preOrderSearch(no);
        }

        System.out.println("当前二叉树为空");
        return null;
    }

    // 中序查找
    public HeroNode infixOrderSearch(int no) {
        if (this.root != null) {
            return this.root.infixOrderSearch(no);
        }

        System.out.println("当前二叉树为空");
        return null;
    }

    // 后序查找
    public HeroNode postOrderSearch(int no) {
        if (this.root != null) {
            return this.root.postOrderSearch(no);
        }

        System.out.println("当前二叉树为空");
        return null;
    }

    // 删除节点
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.printf("当前二叉树为空");
        }
    }

}

// 节点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        super();
        this.no = no;
        this.name = name;
    }

    // 前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    // 后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    // 前序查找
    public HeroNode preOrderSearch(int no) {
        if (this.getNo() == no) {
            return this;
        }

        HeroNode resNode = null;

        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }

        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }

        return resNode;
    }

    // 中序查找
    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;

        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }

        if (resNode != null) {
            return resNode;
        }

        if (this.getNo() == no) {
            return this;
        }

        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }

        return resNode;
    }

    // 后序查找
    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }

        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }

        if (resNode != null) {
            return resNode;
        }

        if (this.getNo() == no) {
            return this;
        }

        return resNode;
    }

    // 删除节点
    public void delNode(int no) {
        // 删除左节点
        if (this.left != null && this.left.no == no) {
            // 左节点为叶子节点
            if (this.left.left == null && this.left.right == null) {
                this.left = null;
            } else {
                // 左节点不为叶子节点
                if (this.left.left != null) {
                    this.left.left.right = this.left.right;
                    this.left = this.left.left;
                } else {
                    this.left = this.left.right;
                }
            }

            return;
        }

        // 删除右节点
        if (this.right != null && this.right.no == no) {
            // 右节点为叶子节点
            if (this.right.left == null && this.right.right == null) {
                this.right = null;
            } else {
                // 右节点不为叶子节点
                if (this.right.left != null) {
                    this.right.left.right = this.right.right;
                    this.right = this.right.left;
                } else {
                    this.right = this.right.right;
                }
            }

            return;
        }

        // 递归左节点
        if (this.left != null) {
            this.left.delNode(no);
        }

        // 递归右节点
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode [no = " + no + ", name = " + name + "]";
    }
}