import java.nio.channels.ClosedByInterruptException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class BinaryTreeDemo {
    //二叉树的非递归遍历

    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        //根节点入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            //出栈  暂时保存栈顶元素
            TreeNode cur = stack.pop();
            list.add(cur.val);
            //不为空情况下，出栈元素的右子树入栈，左子树入栈
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return list;
    }

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        TreeNode cur = root;
        while (true) {
            //cur从根节点出发一直向左，结点入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //若此栈为空，说明没有结点了
            if (stack.isEmpty()) {
                break;
            }
            //遇到空，出栈，
            TreeNode tmp = stack.pop();
            list.add(tmp.val);
            //cur指向出栈元素的右子树（为空的话，继续出栈）（不为空就一直往左继续入栈）
            cur = tmp.right;
        }
        return list;
    }

    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        TreeNode cur = root;
        TreeNode prev = null;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            //得到栈顶元素，但先不访问 （满足条件才可以访问）
            TreeNode tmp = stack.peek();
            //判定一下 如果该栈顶元素没有右子树或者已经访问过了 就可以访问
            if (tmp.right == null || prev == tmp.right) {
                list.add(tmp.val);
                stack.pop();
                prev = tmp; //要更新prev
            } else { //指向栈顶元素的右子树
                cur = tmp.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        BinaryTreeDemo a = new BinaryTreeDemo();
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);

        root.left = two;
        root.right = three;
        two.left = four;
        four.right = seven;

        System.out.println(a.preorderTraversal(root));
        System.out.println(a.inorderTraversal(root));
        System.out.println(a.postorderTraversal(root));
    }
}

