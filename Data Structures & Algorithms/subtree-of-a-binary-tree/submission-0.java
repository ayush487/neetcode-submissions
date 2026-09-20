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
    boolean isSubTree = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        isSub(root, subRoot);
        return isSubTree;
    }

    private void isSub(TreeNode root, TreeNode subRoot) {
        if (isSameTree(root, subRoot)){
            isSubTree = true;
            return;
        }
        if (root.left != null)
            isSub(root.left, subRoot);
        if (root.right != null)
            isSub(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null && q != null) || (p != null && q == null)) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
