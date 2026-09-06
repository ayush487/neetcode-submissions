class MyHashSet {

    private final int SIZE = 1000;

    class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    private Node[] buckets;

    public MyHashSet() {
        this.buckets = new Node[SIZE];
    }

    public void add(int key) {
        if (buckets[key % SIZE] == null) {
            buckets[key % SIZE] = new Node(key);
        } else {
            Node current = buckets[key % SIZE];
            while (current.next != null) {
                if (current.key == key)
                    return;
                current = current.next;
            }
            if (current!=null && current.key != key)
                current.next = new Node(key);
        }
    }
    
    public void remove(int key) {
        if (buckets[key % SIZE] == null) return;
        Node currentNode = buckets[key % SIZE];

        // case 1 : only node
        if (currentNode.next == null) {
            buckets[key % SIZE] = null;
            return;
        }
        // loop to reach the candidate node
        Node prevNode = null;
        while (currentNode != null && currentNode.key != key) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        if (currentNode==null) return;
        // case 2 : first node
        if (prevNode==null) {
            buckets[key % SIZE] = currentNode.next;
            return;
        }
        // case 3 : last node
        if (currentNode.next == null) {
            prevNode.next = null;
            return;
        }
        // case 4 : middle node
        prevNode.next = currentNode.next;
        return;

    }
    
    public boolean contains(int key) {
        if (buckets[key % SIZE] == null) return false;
        Node currentNode = buckets[key % SIZE];
        while (currentNode != null) {
            if (currentNode.key == key) return true;
            currentNode = currentNode.next;
        }
        return false;
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */