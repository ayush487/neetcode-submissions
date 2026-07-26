class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        int[] charS = new int[26];
        int[] charT = new int[26];
        for (int i=0;i<s.length();i++) {
            char cS = s.charAt(i);
            char cT = t.charAt(i);
            charS[cS - 'a']++;
            charT[cT - 'a']++;

        }
        for (int i=0;i<26;i++) {
            if (charS[i]!=charT[i]) return false;
        }
        return true;
    }
}
