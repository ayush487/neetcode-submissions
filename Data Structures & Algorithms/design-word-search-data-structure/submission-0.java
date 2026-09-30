class WordDictionary {

    private class TrieNode {
        char data;
        Map<Character, TrieNode> children;
        boolean word;

        public TrieNode(char data) {
            this.data = data;
            this.children = new HashMap<>();
            this.word = false;
        }

        TrieNode addChild(char c) {
            if (!children.containsKey(c))
                children.put(c, new TrieNode(c));
            return children.get(c);
        }

        boolean hasChild(char c) {
            if (c == '.') return children.size() != 0;
            return children.containsKey(c);
        }

        List<TrieNode> getChild(char c) {
            List<TrieNode> list = new ArrayList<>();
            if (c == '.')
                children.entrySet().stream()
                        .map(e -> e.getValue())
                        .forEach(t -> list.add(t));
            else if (children.containsKey(c)) list.add(children.get(c));
            return list;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode('0');
    }

    public void addWord(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++)
            temp = temp.addChild(word.charAt(i));
        temp.word = true;
    }

    public boolean search(String word) {
        return search(word, root, 0);
    }

    private boolean search(String word, TrieNode prevNode, int index) {
        if (index == word.length()) {
            if (prevNode.word) return true;
            else return false;
        }
        List<TrieNode> children = prevNode.getChild(word.charAt(index));
        if (children.size() == 0) return false;
        for (TrieNode child : children) {
            if (search(word, child, index + 1)) return true;
        }
        return false;
    }
}
