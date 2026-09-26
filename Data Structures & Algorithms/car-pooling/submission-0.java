class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int L = Integer.MAX_VALUE;
        int R = Integer.MIN_VALUE;
        for (int[] trip : trips) {
            L = Math.min(L, trip[1]);
            R = Math.max(R, trip[2]);
        }
        int[] passengerChanges = new int[R - L + 1];
        for (int[] trip : trips) {
            passengerChanges[trip[1] - L] += trip[0];
            passengerChanges[trip[2] - L] -= trip[0];
        }
        int currentPassenger = 0;
        for (int change : passengerChanges) {
            currentPassenger += change;
            if (currentPassenger > capacity) return false;
        }
        return true;
    }
}