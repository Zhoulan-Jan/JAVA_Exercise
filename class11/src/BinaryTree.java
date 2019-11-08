class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }

//    @Override
//    public String toString() {
//        return  val + " ";
//    }
}

public class BinaryTree {
    //TreeNode root = new TreeNode('A');
    //建树
    public void build(TreeNode root) {
        //TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        root.left = B;
        B.left = D;
        B.right = E;
        E.left = G;
        root.right = C;
        C.right = F;
    }

    //先序遍历
    public void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //中序遍历
    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val);
        inOrderTraversal(root.right);
    }
    //后序遍历
    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val);
    }

    //求结点个数
    static int node = 0;
    public void getNode1(TreeNode root) {
        if (root == null) {
            return;
        }
        node++;
        getNode1(root.left);
        getNode1(root.right);
    }

    public int getNode2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1+getNode2(root.left) + getNode2(root.right);
    }

    //求叶子结点
    static int leafNode = 0;
    public void getLeafNode1(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafNode++;
        }
        getLeafNode1(root.left);
        getLeafNode1(root.right);
    }

    public int getLeafNode2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        return getLeafNode2(root.left) + getLeafNode2(root.right);
    }

    //求第k层结点个数
    //左子树第k-1层结点个数+右子树第k+1层结点个数
    //需要考虑k>树的高度？
    public int getLevelSize(TreeNode root, int k) {
        if (root == null || k == 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getLevelSize(root.left,k-1) + getLevelSize(root.right,k-1);
    }

    //查找val所在结点
    public TreeNode find(TreeNode root, char value) {
        if (value == root.val) {
            return root;
        }
        return find(root.left,value);
    }
}
