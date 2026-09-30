class Solution {
    private Map<Character, Integer> orderMap;

    public boolean isAlienSorted(String[] words, String order) {
        orderMap = new HashMap<>(26);
        for (int i = 0; i < order.length(); i++)
            orderMap.put(order.charAt(i), i);
        for (int i = 0; i < words.length - 1; i++) {
            if (!compare(words[i], words[i+1])) return false;
        }
        return true;
    }

    private boolean compare(String word1, String word2) {
        int length = Math.min(word1.length(), word2.length());
        for (int i = 0; i < length; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if (c1 == c2) continue;
            return orderMap.get(c1) < orderMap.get(c2);
        }
        return word1.length() > word2.length() ? false : true;
    }
}