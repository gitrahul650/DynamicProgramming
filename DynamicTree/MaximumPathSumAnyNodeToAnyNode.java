package a1Dynamic.DynamicTree;

public class MaximumPathSumAnyNodeToAnyNode {
    //Given a binary tree, find the maximum path sum.
    // The path may start and end at any node in the tree.
    //Example: Given the below binary tree
    //         1
    //        / \
    //       2   3
    //Return 6. The path 2 -> 1 -> 3 gives the maximum
    // path sum.

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(maxPathSum(root));
    }

    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxPathSumUtil(root);
        return max;
    }

    public static int maxPathSumUtil(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxPathSumUtil(root.left));
        int right = Math.max(0, maxPathSumUtil(root.right));

        max = Math.max(max, left + right + root.val);

        return Math.max(left, right) + root.val;
    }

    //Approach: Dynamic Programming
    public static int maxPathSumDP(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSumUtilDP(root, max);
        return max[0];
    }

    public static int maxPathSumUtilDP(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxPathSumUtilDP(root.left, max));
        int right = Math.max(0, maxPathSumUtilDP(root.right, max));

        max[0] = Math.max(max[0], left + right + root.val);

        return Math.max(left, right) + root.val;
    }

}
