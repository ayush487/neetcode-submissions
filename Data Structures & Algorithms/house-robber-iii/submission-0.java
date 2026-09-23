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
    private Map<TreeNode, Integer> cache;

    public int rob(TreeNode root) {
        cache = new HashMap<>();
        cache.put(null, 0);
        int ans = findMaxRobbery(root);
        return ans;
    }

    private int findMaxRobbery(TreeNode root) {
        if (root == null) return 0;
        if (cache.containsKey(root)) return cache.get(root);

        int res = root.val;

        if (root.left != null)
            res += findMaxRobbery(root.left.left) + findMaxRobbery(root.left.right);
        if (root.right != null)
            res += findMaxRobbery(root.right.left) + findMaxRobbery(root.right.right);

        res = Math.max(res, findMaxRobbery(root.left) + findMaxRobbery(root.right));
        cache.put(root, res);
        return res;

    }
}