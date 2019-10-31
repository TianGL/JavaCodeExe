package cn.geliang.dsa.tree.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname InorderTraversal
 * @Description TODO
 * @Date 2019-08-09
 * @Created by Geliang TIAN
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode node = root;
        while (node != null || !nodeStack.isEmpty()) {
            while (node != null) {
                nodeStack.add(node);
                node = node.left;
            }
            node = nodeStack.pop();
            res.add(node.val);
            node = node.right;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        InorderTraversal sol = new InorderTraversal();
        sol.inorderTraversal(node1);
        System.out.println();
    }
}
