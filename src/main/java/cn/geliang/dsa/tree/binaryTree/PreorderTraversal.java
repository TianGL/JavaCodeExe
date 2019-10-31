package cn.geliang.dsa.tree.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname PreorderTraversal
 * @Description TODO
 * @Date 2019-08-09
 * @Created by Geliang TIAN
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                res.add(node.val);
                if (node.right != null) {
                    treeNodeStack.push(node.right);
                }
                node = node.left;
            }
            if (treeNodeStack.size() != 0) {
                node = treeNodeStack.pop();
            }

        }
        return res;
    }
}
