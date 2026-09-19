class LRUCache {

    private static class Node {
        int key;
        int val;
        Node next;
        Node prev;


        Node(int key,int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {
            return String.format("Key : %d - Value : %d", key, val);
        }
    }

    private Map<Integer, Node> cache;
    private Node left;
    private Node right;
    private final int size;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        this.left = null;
        this.right = null;
        size = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        if (node==left) return node.val;
        remove(key);
        insert(key, node.val);
        return node.val;
    }

    public void put(int key, int value) {
        if (size==1) {
            cache.clear();
            left=new Node(key, value);
            right = left;
            cache.put(key, left);
            return;
        }
        if (left == null) {
            Node node = new Node(key,value);
            cache.put(key, node);
            left = node;
            right = node;
            return;
        }
        if (cache.containsKey(key)) {
            Node existingNode = cache.get(key);
            if (existingNode == left) {
                left.val = value;
            } else {
                remove(key);
                insert(key, value);
            }
        } else {
            if (cache.size() < size) insert(key, value);
            else {
                remove(right.key);
                insert(key, value);
            }
        }
    }

    private void insert(int key, int val) {
        Node node = new Node(key, val);
        node.next = left;
        left.prev = node;
        left = node;
        cache.put(key, node);
    }

    public void remove(int key) {
        Node node = cache.get(key);
        if (node == right) {
            right = right.prev;
            right.next = null;
        } else {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            node.next = null;
            node.prev = null;
        }
        cache.remove(key);
    }
}
