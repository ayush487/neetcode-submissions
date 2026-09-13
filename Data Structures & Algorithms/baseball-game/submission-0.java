class Solution {
    public int calPoints(String[] operations) {
        int totalScore = 0;
        int prev1 = 0;
        int prev2 = 0;
        Stack<Integer> stk = new Stack<>();
        for (String op : operations) {
            if (op.equals("+")) {
                prev1 = stk.pop();
                prev2 = stk.peek();
                stk.push(prev1);
                stk.push(prev1+prev2);
                totalScore += prev1 + prev2;
            } else if (op.equals("D")) {
                prev1 = stk.peek();
                totalScore += (prev1*2);
                stk.push(prev1*2);
            } else if (op.equals("C")) {
                prev1 = stk.pop();
                totalScore -= prev1;
            } else {
                int sc = Integer.parseInt(op);
                stk.push(sc);
                totalScore += sc;
            }
        }
        return totalScore;
    }
}