/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> oldNewMap;
    public Node cloneGraph(Node node) {
        oldNewMap = new HashMap<>();
        return dfs(node);
    }

    private Node dfs(Node node) {
        if (node==null) return null;

        if (oldNewMap.containsKey(node)) return oldNewMap.get(node);

        Node newNode = new Node(node.val);
        oldNewMap.put(node, newNode);

        for (Node ne : node.neighbors)  {
            newNode.neighbors.add(dfs(ne));
        }
        return newNode;
    }
}