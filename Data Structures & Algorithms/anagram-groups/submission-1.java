class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> solution = new ArrayList<>();
        for (String word : strs) {
            String s = getBinaryStr(word);
            if (map.containsKey(s)) {
                List<String> anagramGroup = map.get(s);
                anagramGroup.add(word);
            } else {
                List<String> anagramGroup = new ArrayList<>();
                anagramGroup.add(word);
                map.put(s, anagramGroup);
            }
        }
        for (String w : map.keySet()) {
            solution.add(map.get(w));
        }
        return solution;
    }

    private String getBinaryStr(String word) {
        int[] arr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int e : arr)
            sb.append(String.format("%03d", e));
        return sb.toString();
    }
}
