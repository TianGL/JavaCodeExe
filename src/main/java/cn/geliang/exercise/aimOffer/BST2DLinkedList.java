package cn.geliang.exercise.aimOffer;

/**
 * @Classname BST2DLinkedList
 * @Description TODO
 * @Date 2019-08-09
 * @Created by Geliang TIAN
 */

//题目描述
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
public class BST2DLinkedList {

    TreeNode dummyhead;
    TreeNode pre;

    public TreeNode Convert(TreeNode pRootOfTree) {
        dummyhead = new TreeNode(-1);
        inorderTraversal(pRootOfTree);
        return dummyhead.right;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        if (pre == null) {
            dummyhead.right = node;
            pre = node;
        } else {
            pre.right = node;
            node.left = pre;
            pre = node;
        }
        inorderTraversal(node.right);
    }
}
