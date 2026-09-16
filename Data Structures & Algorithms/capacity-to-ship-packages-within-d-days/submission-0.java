class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for (int w : weights) {
            sum += w;
            max = Math.max(max, w);
        }
        if (weights.length == days) return max;

        int ll = max;
        int ul = sum;
        int minWeightCapacity = sum;
        while (ll <= ul) {
            int capacity = ll + (ul - ll) / 2;
            if (canThisBeltShipWithinDays(weights, days, capacity)) {
                minWeightCapacity = Math.min(minWeightCapacity, capacity);
                ul = capacity - 1;
            } else ll = capacity + 1;
        }

        return minWeightCapacity;
    }

    private boolean canThisBeltShipWithinDays(int[] weights, int days, int capacity) {
        int cap = capacity;
        int currentDays = 1;
        for (int w : weights) {
            if (cap - w < 0) {
                currentDays++;
                cap = capacity - w;
            } else {
                cap -= w;
            }
            if (currentDays > days) return false;
        }
        return true;
    }
}