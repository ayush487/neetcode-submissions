class Solution {
    Map<String, List<String>> graph = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean containsEndWord = false;
        boolean containsBeginWord = false;
        for (String word : wordList) {
            if (word.equals(endWord)) containsEndWord = true;
            if (word.equals(beginWord)) containsBeginWord = true;
        }
        if (!containsEndWord) return 0;
        if (!containsBeginWord) {
            List<String> beginConnections = new ArrayList<>();
            for (String word : wordList) {
                if (isConnection(beginWord, word)) beginConnections.add(word);
            }
            if (beginConnections.size() == 0) return 0;
            graph.put(beginWord, beginConnections);
        }

        for (String w1 : wordList) {
            for (String w2 : wordList) {
                if (w1.equals(w2)) continue;
                if (isConnection(w1, w2)){
                    graph.computeIfAbsent(w1, k -> new ArrayList<>()).add(w2);
                }

            }
        }
        if (!graph.containsKey(beginWord) || graph.size()==0) return 0;
        if (graph.size() == 0) return 0;
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 1;

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return count;
                }
                visited.add(word);
                for (String wordConections : graph.get(word)) {
                    if (visited.contains(wordConections)) continue;
                    queue.offer(wordConections);
                }
            }
            count++;
        }

        return 0;
    }


    private boolean isConnection(String word1, String word2) {
        int sameCharsRequired = word1.length() - 1;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i)) sameCharsRequired--;
        }
        boolean ans = sameCharsRequired==0;
        return ans;
    }
}
