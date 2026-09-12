class Solution {
   public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int[] arrS = createCharCountArray(s);
        int[] arrT = createCharCountArray(t);
        int[] currentWindowArr = new int[52];
        int[] bestWindow = new int[]{0, 0, Integer.MAX_VALUE};
        int count = 0;
        if (doesContains(arrS, arrT)) {
            int l = 0;
            int r = 0;
            while (r < s.length()) {
                char c = s.charAt(r);
                currentWindowArr[c < 'a' ? (c - 'A') : (c - 'a' + 26)]++;
                if (doesContains(currentWindowArr, arrT)) {
                    int currWindowSize = r - l + 1;
                    if (bestWindow[2] > currWindowSize) {
                        bestWindow[0] = l;
                        bestWindow[1] = r;
                        bestWindow[2] = currWindowSize;
                    }
                    while (l < r) {
                        char d = s.charAt(l);
                        l++;
                        currentWindowArr[d < 'a' ? d - 'A' : d - 'a' + 26]--;
                        if (doesContains(currentWindowArr, arrT)) {
                            currWindowSize = r - l + 1;
                            if (bestWindow[2] > currWindowSize) {
                                bestWindow[0] = l;
                                bestWindow[1] = r;
                                bestWindow[2] = currWindowSize;

                            }
                        } else break;
                    }
                }
                r++;
            }
        }

        if (bestWindow[2] == Integer.MAX_VALUE) return "";
        else return s.substring(bestWindow[0], bestWindow[1] + 1);

    }

    private boolean doesContains(int[] arrS, int[] arrT) {
        for (int i = 0; i < 52; i++) if (arrT[i] > arrS[i]) return false;
        return true;
    }

    private int[] createCharCountArray(String s) {
        int[] arr = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 'a') arr[c - 'A']++;
            else arr[c - 'a' + 26]++;
        }
        return arr;
    }
}
