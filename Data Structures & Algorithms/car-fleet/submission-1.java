class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i=0;i<position.length;i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a,b) -> a[0] > b[0] ? -1 : 1);

        Stack<Double> stack = new Stack<>();

        for (int[] car : cars) {
            double timeToReach = (double)(target - car[0]) / (double)(car[1]);
            if (stack.isEmpty() || timeToReach > stack.peek()) stack.push(timeToReach);
        }

        return stack.size();
    }
}