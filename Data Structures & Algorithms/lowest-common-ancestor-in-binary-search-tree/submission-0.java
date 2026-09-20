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
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca = root;
        findLCA(root, p, q);
        return lca;
    }

    private void findLCA(TreeNode node, TreeNode p, TreeNode q) {
        if ((node.val == p.val) || (node.val == q.val) || (node.val > p.val && node.val < q.val) || (node.val < p.val && node.val > q.val)) {
            lca = node;
            return;
        }
        if (node.val > p.val && node.val > q.val) findLCA(node.left, p, q);
        else findLCA(node.right, p, q);
    }
}
