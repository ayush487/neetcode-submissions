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
    public boolean isValidBST(TreeNode root) {
        return isInRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isInRange(TreeNode node, int start, int end) {
        if (node==null) return true;
        if (node.val <= start || node.val >= end) return false;
        return isInRange(node.left, start, node.val) && isInRange(node.right, node.val, end);
    }
}
