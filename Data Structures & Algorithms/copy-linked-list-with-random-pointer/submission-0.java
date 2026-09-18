/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head==null) return null;
        Node temp = head;
        int size = 0;
        Map<Integer, Integer> oldLLIndexMapping = new HashMap<>();
        while(temp!=null) {
            oldLLIndexMapping.put(temp.hashCode(), size);
            temp = temp.next;
            size++;
        }

        Node[] nodeArr = new Node[size];
        temp = head;
        for (int i=0;i<size;i++) {
            nodeArr[i] = temp;
            temp = temp.next;
        }
        Node[] newNodeArr = new Node[size];

        Node newHead = new Node(head.val);
        newNodeArr[0] = newHead;
        temp = newHead;
        for (int i=1;i<nodeArr.length;i++) {
            Node newNode = new Node(nodeArr[i].val);
            newNodeArr[i] = newNode;
            temp.next = newNode;
            temp = temp.next;
        }
        for (int i =0;i<size;i++) {
            Node randomNode = nodeArr[i].random;
            if (randomNode==null) newNodeArr[i].random = null;
            else {
                int randomNodeIdx = oldLLIndexMapping.get(randomNode.hashCode());
                newNodeArr[i].random = newNodeArr[randomNodeIdx];
            }
        }
        return newHead;
    }
}
