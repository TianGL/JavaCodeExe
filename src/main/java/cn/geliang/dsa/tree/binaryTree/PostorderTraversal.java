package cn.geliang.dsa.tree.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Classname PostorderTraversal
 * @Description TODO
 * @Date 2019-08-09
 * @Created by Geliang TIAN
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        while (node != null || stack.size() != 0) {
            while (node != null) {
                res.add(node.val);
                if (node.left != null) {
                    stack.push(node.left);
                }
                node = node.right;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
            }
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        if (node == null) {
            return res;
        }
        while (!s1.isEmpty()) {
            node = s1.pop();
            if (node.left != null) {
                s1.push(node.left);
            }
            if (node.right != null) {
                s1.push(node.right);
            }
            s2.push(node);
        }
        while (!s2.isEmpty()) {
            res.add(s2.pop().val);
        }

        return res;
    }
}
