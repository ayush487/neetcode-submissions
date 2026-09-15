class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int length = heights.length;
        int currMax = 0;
        for (int i = 0; i < length; i++) {
            int start = i;
            if (!stack.isEmpty() && stack.peek()[1] == heights[i]) continue;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] lastBuilding = stack.pop();
                int lastBuildingHeight = (i - lastBuilding[0]) * lastBuilding[1];
                currMax = Math.max(currMax, lastBuildingHeight);
                start = lastBuilding[0];
            }
            stack.push(new int[]{start, heights[i]});
        }

        while(!stack.isEmpty()) {
            int[] ruins = stack.pop();
            int ruinsHeight = (length - ruins[0]) * ruins[1];
            currMax = Math.max(ruinsHeight, currMax);
        }
        return currMax;
    }
}
