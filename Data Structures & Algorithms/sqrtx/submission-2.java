class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        long ul = x;
        long ll = 1;
        while (true) {
            long mid = ll + (ul-ll) / 2;
            long midSqr = mid * mid;
            if (midSqr <= x) {
                long nextSqr = (mid + 1) * (mid + 1);
                if (nextSqr > x) return (int)mid;
                else ll = mid + 1;
            } else ul = mid - 1;
        }
    }
}