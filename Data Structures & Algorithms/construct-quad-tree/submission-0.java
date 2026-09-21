/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        Node root = new Node();
        int size = grid.length;
        int val = getVal(grid, size, 0, 0);
        if (val == -1) {
            root.val = true;
            root.isLeaf = false;
            root.topLeft = construct(grid, size / 2, 0, 0);
            root.topRight = construct(grid, size / 2, size / 2, 0);
            root.bottomLeft = construct(grid, size / 2, 0, size / 2);
            root.bottomRight = construct(grid, size / 2, size / 2, size / 2);
        } else {
            root.val = val == 1;
            root.isLeaf = true;
        }
        return root;
    }

    private Node construct(int[][] grid, int size, int startX, int startY) {
        int val = getVal(grid, size, startX, startY);
        if (val != -1) return new Node(val == 1, true);
        else {
            Node root = new Node();
            root.val = false;
            root.isLeaf = false;
            root.topLeft = construct(grid, size / 2, startX, startY);
            root.topRight = construct(grid, size / 2, startX + size / 2, startY);
            root.bottomLeft = construct(grid, size / 2, startX, startY + size / 2);
            root.bottomRight = construct(grid, size / 2, startX + size / 2, startY + size / 2);
            return root;
        }
    }

    private int getVal(int[][] grid, int size, int startX, int startY) {
        int probRes = grid[startY][startX];
        for (int i = startY; i < startY + size; i++)
            for (int j = startX; j < startX + size; j++)
                if (grid[i][j] != probRes) return -1;
        return probRes;
    }
}