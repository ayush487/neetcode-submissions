
class StockSpanner {

    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        if (stack.isEmpty()) {
            stack.push(new int[]{price, 1});
            return 1;
        } else {
            int currentSpan = 1;
            while (true) {
                if (stack.isEmpty()) {
                    stack.push(new int[]{price, currentSpan});
                    break;
                }
                int[] prevStock = stack.peek();
                if (prevStock[0] > price) {
                    stack.push(new int[]{price, currentSpan});
                    break;
                } else {
                    stack.pop();
                    currentSpan += prevStock[1];
                }
            }
            return currentSpan;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */