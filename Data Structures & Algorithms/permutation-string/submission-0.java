class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length()<s1.length()) return false;
        int asciA = 'a';
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i=0;i<s1.length();i++) {
            arr1[s1.charAt(i) - asciA]++;
            arr2[s2.charAt(i) - asciA]++;
        }
        if (isEqual(arr1, arr2)) return true;
        int l = 0;
        for (int r=s1.length();r<s2.length();r++) {
            arr2[s2.charAt(l++) - asciA]--;
            arr2[s2.charAt(r)- asciA]++;
            if (isEqual(arr1, arr2)) return true;
        }
        return false;
    }
    private boolean isEqual(int[] arr1, int[] arr2) {
        for (int i=0;i<arr1.length;i++) {
            if (arr1[i]!=arr2[i]) return false;
        }
        return true;
    }
}
