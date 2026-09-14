class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i=0;i<temperatures.length;i++) {
            while(!stack.isEmpty() && stack.peek()[0]<temperatures[i]) {
                int[] temp = stack.pop();
                res[temp[1]] = i - temp[1];
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return res;
    }
}
