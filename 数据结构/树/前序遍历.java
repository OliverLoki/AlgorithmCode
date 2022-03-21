package 树;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 前序遍历 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //递归的方式
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        accessTree(root, res);
        return res;
    }

    //当一个结点为空时，将该结点加入集合，然后中序遍历它的右结点
    public static void accessTree(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        res.add(root.val);
        accessTree(root.left, res);
        accessTree(root.right, res);
    }

    //循环的方式遍历
    public static List<Integer> anotherWay(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {//
            while (root != null) {//找到没有左节点的那个结点
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }

}
