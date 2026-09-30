class Solution {
    private List<String> list;
    private String segment;
    private List<String> wordDict;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.list = new ArrayList<>();
        this.segment = s;
        this.wordDict = wordDict;
        dfs(new StringBuilder(), 0);
        return list;
    }

    private void dfs(StringBuilder currentSb, int index) {
        if (index==segment.length()) {
            list.add(currentSb.toString().trim());
            return;
        }
        for (String word : wordDict) {
            if (segment.substring(index).startsWith(word)) {
                int sbLength = currentSb.length();
                currentSb.append(word);
                currentSb.append(" ");
                dfs(currentSb, index+word.length());
                currentSb.delete(sbLength, currentSb.length());
            }
        }
    }
}