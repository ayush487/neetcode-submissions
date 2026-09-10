class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int w1P = 0;
        int w2P = 0;
        int smallLength = Math.min(word1.length(), word2.length());
        for (int i = 0; i < smallLength; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            w1P++;
            w2P++;
        }
        while (w1P < word1.length()) {
            sb.append(word1.charAt(w1P++));
        }
        while (w2P < word2.length()) {
            sb.append(word2.charAt(w2P++));
        }
        return sb.toString();
    }
}