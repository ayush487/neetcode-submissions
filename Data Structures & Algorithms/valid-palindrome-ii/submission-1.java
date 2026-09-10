class Solution {
    public boolean validPalindrome(String s) {
        boolean canBypass = true;
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        while (leftPointer <= rightPointer) {

            if (s.charAt(leftPointer) == s.charAt(rightPointer)) {
                leftPointer++;
                rightPointer--;
            } else {
                boolean p1 = isActualPalindrome(s, leftPointer + 1, rightPointer);
                boolean p2 = isActualPalindrome(s, leftPointer, rightPointer - 1);
                return (p1 || p2);

            }
        }
        return true;
    }

    private boolean isActualPalindrome(String s, int start, int end) {
        final int length = end - start + 1;
        for (int i = 0; i < length / 2; i++)
            if (s.charAt(i + start) != s.charAt(end - i)) return false;
        return true;
    }
}