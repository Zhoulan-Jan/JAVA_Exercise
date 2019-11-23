

public class BinarySearchTree {
    public static class TreeNode {
        public int key;
        public int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //建立根节点
    private static TreeNode root = null;

    //查找
    public static boolean search(int target) {
        if (root == null) { //加了static root 不可用了
            return false;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.key == target) {
                return true;
            } else if (cur.key > target) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return false;
    }

    //建树
    public static void insert(int key, int val) {
        TreeNode node = new TreeNode(key, val);
        if (root == null) {
            root = node;
            return;
        }
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.key == key) {
                //该节点已存在
                return;
            } else if (cur.key > key) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        } //循环结束后，cur == null
        if (key < parent.key) {
            parent.left = node;
        } else {
            parent.right = node;
        }
    }

    //中序遍历
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.key + " ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        insert(3,0);
        insert(2,0);
        insert(9,0);
        insert(5,0);
        insert(0,0);
        insert(1,0);
        insert(4,0);
        inOrder(root);
        long end=System.currentTimeMillis();
        System.out.println("程序运行 "+ (end-startTime) +" ms");
    }
}
