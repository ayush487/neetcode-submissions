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
    private static class TreeNodeLevels {
        int level;
        TreeNode node;

        TreeNodeLevels(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNodeLevels> queue = new LinkedList<>();
        if (root != null) queue.offer(new TreeNodeLevels(0, root));
        while (!queue.isEmpty()) {
            TreeNodeLevels lNode = queue.poll();
            int alSize = list.size();
            if (alSize == lNode.level) {
                list.add(new ArrayList<>());
            }
            list.get(lNode.level).add(lNode.node.val);
            if (lNode.node.left != null)
                queue.offer(new TreeNodeLevels(lNode.level + 1, lNode.node.left));
            if (lNode.node.right != null)
                queue.offer(new TreeNodeLevels(lNode.level + 1, lNode.node.right));
        }
        return list;
    }
}
