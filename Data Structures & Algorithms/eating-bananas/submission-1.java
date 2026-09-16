class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int p : piles) max = Math.max(max, p);
        if (piles.length==h) return max;
        int ll = 1;
        int ul = max;
        while (ll <= ul) {
            int mid = ll + (ul - ll) / 2;
            if (canEat(piles, h, mid)) {
                max = Math.min(max, mid);
                ul = mid - 1;
            }
            else ll = mid + 1;
        }
        return max;
    }

    public boolean canEat(int[] piles, int h, int k) {
        int hoursTaken = 0;
        for (int pile : piles) {
            hoursTaken += pile / k;
            hoursTaken += pile % k == 0 ? 0 : 1;
            if (hoursTaken > h) return false;
        }
        return true;
    }
}
