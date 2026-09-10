class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder originalSB = new StringBuilder();
        for (int i=0;i<s.length();i++)
            if (isAlphaNumeric(s.charAt(i))) originalSB.append(s.charAt(i));
        String originalString = originalSB.toString();
        StringBuilder reverseSB = new StringBuilder();
        for (int i=s.length()-1;i>=0;i--)
            if (isAlphaNumeric(s.charAt(i))) reverseSB.append(s.charAt(i));
        String reverseString = reverseSB.toString();
        return originalString.equals(reverseString);
    }

    private boolean isAlphaNumeric(char c) {
        int ascii0 = '0';
        int ascii9 = '9';
        int asciiA = 'a';
        int asciiZ = 'z';
        if ((c >= ascii0 && c <= ascii9) || (c >= asciiA && c <= asciiZ)) return true;
        return false;
    }
}
