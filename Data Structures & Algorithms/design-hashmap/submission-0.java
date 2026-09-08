class MyHashMap {

    private final int SIZE = 1000;

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] buckets;

    public MyHashMap() {
        this.buckets = new Node[SIZE];
    }

    public void put(int key, int value) {
        int index = key % SIZE;
        if (buckets[index] == null)
            buckets[index] = new Node(key, value);
        else {
            Node currentNode = buckets[index];
            while (currentNode.next != null) {
                if (currentNode.key == key) {
                    currentNode.value = value;
                    return;
                }
                currentNode = currentNode.next;
            }
            if (currentNode.key == key) currentNode.value = value;
            else currentNode.next = new Node(key, value);
        }
    }

    public int get(int key) {
        int index = key % SIZE;
        if (buckets[index] == null) return -1;
        Node currentNode = buckets[index];
        while (currentNode != null) {
            if (currentNode.key == key) return currentNode.value;
            currentNode = currentNode.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % SIZE;
        if (buckets[index] == null) return;

        Node currentNode = buckets[index];
        if (currentNode.key == key) buckets[index] = currentNode.next;
        else {
            Node prev = currentNode;
            currentNode = currentNode.next;
            while (currentNode != null) {
                if (currentNode.key == key) {
                    prev.next = currentNode.next;
                    return;
                }
                prev = currentNode;
                currentNode = currentNode.next;
            }
        }

    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */