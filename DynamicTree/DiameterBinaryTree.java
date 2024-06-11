package a1Dynamic.DynamicTree;

public class DiameterBinaryTree {
    //Given a binary tree, you need to compute the length
    // of the diameter of the tree.
    //The diameter of a binary tree is the length of
    // the longest path between any two nodes in a tree.
    //This path may or may not pass through the root.
    //Example: Given a binary tree
    //          1
    //         / \
    //        2   3
    //       / \
    //      4   5
    //Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

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
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }

    static int max = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root);
        return max;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return 1 + Math.max(left, right);
    }

    //Solve by Dynamic Programming
    //Approach: Dynamic Programming
    public static int diameterOfBinaryTreeDP(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = new int[1];
        maxDepth(root, max);
        return max[0];
    }

    public static int maxDepth(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left, max);
        int right = maxDepth(root.right, max);

        max[0] = Math.max(max[0], left + right);

        return 1 + Math.max(left, right);
    }


}
