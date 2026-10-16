class Solution {
    private int[][] palindromeBox;

    public int countSubstrings(String s) {
        this.palindromeBox = new int[s.length()][s.length()];

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                var ans = isPalindrome(s, i, j);
                if (ans) count++;
            }
        }
        return count;
    }

    private boolean isPalindrome(String s, int i, int j) {
        if (palindromeBox[i][j] == 0) {
            if (s.charAt(i) != s.charAt(j)) {
                palindromeBox[i][j] = -1;
                return false;
            }
            if (i >= j) {
                palindromeBox[i][j] = 1;
                return true;
            }
            boolean ans = isPalindrome(s, i + 1, j - 1);
            palindromeBox[i][j] = ans ? 1 : -1;
            return ans;
        }
        return palindromeBox[i][j] == 1;
    }
}
