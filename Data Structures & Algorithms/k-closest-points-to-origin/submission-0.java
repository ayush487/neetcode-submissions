class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (arr1, arr2) -> (distanceOrigin(arr1) - distanceOrigin(arr2)) > 0 ? -1 : 1);
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) pq.poll();
        }
        int[][] result = new int[k][2];
        for (int i=0;i<k;i++) {
            result[i] = pq.poll();
        }
        return result;
    }

    private double distanceOrigin(int[] cords) {
        return Math.sqrt(cords[0] * cords[0] + cords[1] * cords[1]);
    }
}
