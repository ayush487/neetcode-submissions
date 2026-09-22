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

public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "N";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) sb.append("N,");
            else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }


    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        if (nodes[0].equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int idx = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!nodes[idx].equals("N")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[idx]));
                node.left = leftNode;
                queue.offer(leftNode);
            }
            idx++;
            if (!nodes[idx].equals("N")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[idx]));
                node.right = rightNode;
                queue.offer(rightNode);
            }
            idx++;
        }
        return root;
    }
}
