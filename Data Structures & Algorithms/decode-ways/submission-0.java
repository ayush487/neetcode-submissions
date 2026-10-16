class Solution {
     private Map<Integer,Integer> memo;

    public int numDecodings(String s) {
        memo = new HashMap<>();
        return dfs(0, s);
    }

    private int dfs(int i, String s) {
        if (i == s.length()) return 1;
        if (memo.containsKey(i)) return memo.get(i);
        if (s.charAt(i) == '0') return 0;
        int res = dfs(i + 1, s);
        if (i < s.length() - 1) {
            if (s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1) < '7'))
                res += dfs(i+2, s);
        }
        memo.put(i, res);
        return res;
    }
}
