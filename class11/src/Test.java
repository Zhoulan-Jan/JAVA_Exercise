public class Test {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode('A');
        tree.build(root);
        tree.preOrderTraversal(root);System.out.println();
        tree.inOrderTraversal(root);System.out.println();
        tree.postOrderTraversal(root);
    }
}
