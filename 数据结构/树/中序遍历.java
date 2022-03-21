package 树;


import java.util.*;

public class 中序遍历 {
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
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        accessTree(root, res);

        return res;
    }

    //当一个结点左节点为空时，将该结点加入集合，然后中序遍历它的右结点
    public static void accessTree(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        accessTree(root.left, res);
        res.add(root.val);
        accessTree(root.right, res);
    }


    //使用循环遍历二叉树
    public static List<Integer> anotherWay(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {//
            while (root != null) {//找到没有左节点的那个结点
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
