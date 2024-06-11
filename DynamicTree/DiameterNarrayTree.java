package a1Dynamic.DynamicTree;

public class DiameterNarrayTree {
    //Given an N-ary tree, find the diameter of the tree.
    //The diameter of an N-ary tree is the length of the
    // longest path between any two nodes in a tree.
    //This path may or may not pass through the root.
    //Example: Given a binary tree
    //          1
    //         /|\ \
    //        2 3 4 5
    //       /|\
    //      6 7 8
    //Return 4, which is the length of the path [6,2,1,3,4,8,7,2].

    static class TreeNode {
        int val;
        TreeNode[] children;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.children = new TreeNode[4];
        root.children[0] = new TreeNode(2);
        root.children[1] = new TreeNode(3);
        root.children[2] = new TreeNode(4);
        root.children[3] = new TreeNode(5);
        root.children[0].children = new TreeNode[3];
        root.children[0].children[0] = new TreeNode(6);
        root.children[0].children[1] = new TreeNode(7);
        root.children[0].children[2] = new TreeNode(8);
        System.out.println(diameterOfNaryTreeDP(root));
    }

    static int max = 0;
    public static int diameterOfNaryTree(TreeNode root) {
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

        int firstMax = 0;
        int secondMax = 0;
        for (TreeNode child : root.children) {
            int depth = maxDepth(child);
            if (depth > firstMax) {
                secondMax = firstMax;
                firstMax = depth;
            } else if (depth > secondMax) {
                secondMax = depth;
            }
        }

        max = Math.max(max, firstMax + secondMax);

        return 1 + firstMax;
    }

    //Solve by Dynamic Programming
    //Approach: Dynamic Programming
    public static int diameterOfNaryTreeDP(TreeNode root) {
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

        int firstMax = 0;
        int secondMax = 0;
        for (TreeNode child : root.children) {
            int depth = maxDepth(child, max);
            if (depth > firstMax) {
                secondMax = firstMax;
                firstMax = depth;
            } else if (depth > secondMax) {
                secondMax = depth;
            }
        }

        max[0] = Math.max(max[0], firstMax + secondMax);

        return 1 + firstMax;
    }

}
