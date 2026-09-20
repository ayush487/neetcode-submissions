/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root, 0);
    }

    private int diameter(TreeNode node, int currentMax) {
        if (node == null) return currentMax;
        int leftDepth = depth(node.left, 0);
        int rightDepth = depth(node.right, 0);
        int sum = leftDepth + rightDepth;
        currentMax = Math.max(currentMax, sum);
        return Math.max(diameter(node.left, currentMax), diameter(node.right, currentMax));
    }

    private int depth(TreeNode node, int currentDepth) {
        if (node == null) return currentDepth;
        return Math.max(depth(node.left, currentDepth + 1), depth(node.right, currentDepth + 1));
    }
}
