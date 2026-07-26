class Solution {
    public String longestCommonPrefix(String[] strs) {
        String currentPrefix = strs[0];
        if (strs.length==1) return currentPrefix;
        for (int i=1;i<strs.length;i++) {
            if (currentPrefix.length()==0) return "";
            currentPrefix = getCommonPrefix(currentPrefix, strs[i]);
        }
        return currentPrefix;
    }

    private String getCommonPrefix(String currentPrefix, String word) {
        if (currentPrefix.length()>word.length()) currentPrefix = currentPrefix.substring(0, word.length());
        StringBuilder newPrefixBuilder = new StringBuilder();
        for (int i=0;i<currentPrefix.length();i++) {
            if (currentPrefix.charAt(i)==word.charAt(i)) newPrefixBuilder.append(currentPrefix.charAt(i));
            else return newPrefixBuilder.toString();
        }
        return newPrefixBuilder.toString();
    }
}