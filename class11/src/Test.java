public class Test {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode('A');
        tree.build(root);
        //前中后遍历
        tree.preOrderTraversal(root);System.out.println();
        tree.inOrderTraversal(root);System.out.println();
        tree.postOrderTraversal(root);System.out.println();
        //求结点个数
        tree.getNode1(root);//0?
        System.out.println(BinaryTree.node);
        System.out.println(tree.getNode2(root));
        //求叶子结点
        tree.getLeafNode1(root);
        System.out.println(BinaryTree.leafNode);
        System.out.println(tree.getLeafNode2(root));
        //求第k层结点个数
        System.out.println(tree.getLevelSize(root,4));
        //查找val所在结点
        System.out.println(tree.find(root,'G'));
    }
}
