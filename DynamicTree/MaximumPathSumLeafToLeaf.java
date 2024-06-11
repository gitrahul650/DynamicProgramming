package a1Dynamic.DynamicTree;

public class MaximumPathSumLeafToLeaf {
    //If a binary tree is given, how to find Maximum path sum
    // between two leaves of binary tree.
    //
    //All should be numbers
    //The maximum sum path may or may not go through root.
    //For example, in the following binary tree, the maximum sum
    // is 27(3 + 6 + 9 + 0 -1 + 10). Expected time complexity is O(n)
    // where n is the number of nodes in the given Binary Tree.
    //        -15
    //        / \
    //       5   6
    //      / \ / \
    //    -8  1 3  9
    //   /  / \   / \
    //  2  6   0 6  4
    //     / \
    //    0   10
    //Approach: Dynamic Programming

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-15);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(-8);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(2);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(0);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(4);
        root.left.right.left.left = new TreeNode(0);
        root.left.right.left.right = new TreeNode(10);
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
