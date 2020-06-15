public class TestBinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(6);
        bst.insert(2);
        bst.insert(8);
        bst.insert(1);
        bst.insert(5);
        bst.insert(3);
        bst.insert(4);

        System.out.println("删除前");
        System.out.println(bst.contains(2));
        bst.printTree(1);

        bst.remove(2);

        System.out.println("删除后");
        System.out.println(bst.contains(2));
        bst.printTree(1);

    }
}
