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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null) return new TreeNode(val);
        TreeNode temp = root;
        while (!isThisNodeFitParent(temp, val)) {
            if (temp.val > val) temp = temp.left;
            else temp = temp.right;
        }
        if (temp.val > val) temp.left = new TreeNode(val);
        else temp.right = new TreeNode(val);
        return root;
    }

    private boolean isThisNodeFitParent(TreeNode node, int val) {
        if (node.left == null && node.right == null) return true;
        else if (node.left==null) {
            if (node.val > val && node.right.val>val) return true;
            else return false;
        }
        else if (node.right==null) {
            if (node.val < val && node.left.val < val) return true;
            else return false;
        }
        return false;
    }
}