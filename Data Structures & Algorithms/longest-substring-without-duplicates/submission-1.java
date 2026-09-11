class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int highest = 0;
        int currLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i))>=i-currLength) {
                currLength = i - map.get(s.charAt(i));
                map.put(s.charAt(i), i);
            } else {
                map.put(s.charAt(i), i);
                currLength++;
                highest = Math.max(highest, currLength);
            }
        }
        return highest;
    }
}
