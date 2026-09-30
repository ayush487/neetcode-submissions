class PrefixTree {

    private class TrieNode {
        char data;
        private TrieNode[] children;
        boolean word;

        TrieNode(char data) {
            this.data = data;
            this.word = false;
            this.children = new TrieNode[26];
        }

        TrieNode addChild(char c) {
            int index = c - 'a';
            if (children[index] == null) children[index] = new TrieNode(c);
            return children[index];
        }

        TrieNode getChild(char c) {
            return children[c - 'a'];
        }

        boolean isChild(char c) {
            int index = c - 'a';
            if (children[index] == null) return false;
            else return true;
        }
    }

    private TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode('0');
    }

    public void insert(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++)
            temp = temp.addChild(word.charAt(i));
        temp.word = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.isChild(c)) temp = temp.getChild(c);
            else return false;
        }
        return temp.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (temp.isChild(c)) temp = temp.getChild(c);
            else return false;
        }
        return true;
    }
}
