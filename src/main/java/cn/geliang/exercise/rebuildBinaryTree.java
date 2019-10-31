package cn.geliang.exercise;

/**
 * @Classname rebuildBinaryTree
 * @Description TODO
 * @Date 2019-08-30
 * @Created by Geliang TIAN
 */
public class rebuildBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static int[] zhong;
    private static int[] qian;

    public static void main(String[] args) {
        zhong = new int[]{1,2,3,4,5,6,7};
        qian = new int[]{4,1,3,2,6,5,7};
        TreeNode node = reBuild(0, qian.length-1, 0, zhong.length-1);
        System.out.println();
    }

    private static TreeNode reBuild(int l1, int r1, int l2, int r2) {
        if (l1 > r1 || l2 > r2) {
            return null;
        }
        TreeNode root = new TreeNode(qian[l1]);
        int next = l2;
        while (zhong[next] != qian[l1]) {
            next++;
        }
        int len = next - l2;
        root.left = reBuild(l1+1, l1 + len, l2, next);
        root.right = reBuild(l1+len + 1, r1, next+1, r2);
        return root;

    }
}
