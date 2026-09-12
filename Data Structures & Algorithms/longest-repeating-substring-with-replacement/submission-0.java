class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            charSet.add(s.charAt(i));
        }
        int longestSubStringLength = 0;
        for (char c : charSet) {
            int count = 0;
            int l = 0;
            for (int r = 0; r < s.length(); r++) {
                if (s.charAt(r) == c) count++;

                while ((r - l + 1) - count > k) {
                    if (s.charAt(l) == c) count--;
                    l++;
                }

                longestSubStringLength = Math.max(longestSubStringLength, r - l + 1);
            }
        }
        return longestSubStringLength;
    }
}
