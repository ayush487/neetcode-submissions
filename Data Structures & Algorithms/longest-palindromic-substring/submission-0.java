class Solution {
    private int[][] palindromeBox;

    public String longestPalindrome(String s) {
        this.palindromeBox = new int[s.length()][s.length()]; // 0-> no info, -1 -> no, 1 -> yes
        var ans = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                boolean isPalindrome = isPalindrome(s, i, j);
                if (isPalindrome)
                    if (ans.length() < j - i + 1) ans = s.substring(i, j + 1);
            }
        }
        return ans;
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
            palindromeBox[i + 1][j - 1] = ans ? 1 : -1;
            return ans;
        }
        return palindromeBox[i][j] == 1;
    }
}
