class FreqStack {

    private Map<Integer, Integer> count;
    private Map<Integer, Stack<Integer>> stacks;

    private int maxCount = 0;

    public FreqStack() {
        this.count = new HashMap<>();
        this.stacks = new HashMap<>();
    }

    public void push(int val) {
        int valCount = count.getOrDefault(val, 0) + 1;
        count.put(val, valCount);
        if (stacks.containsKey(valCount)) {
            stacks.get(valCount).push(val);
        } else {
            var stk = new Stack<Integer>();
            stk.push(val);
            stacks.put(valCount, stk);
        }
        maxCount = Math.max(maxCount, valCount);
    }

    public int pop() {
        int poppedElement = stacks.get(maxCount).pop();
        int prevCount = count.get(poppedElement);
        if (prevCount == 1) count.remove(poppedElement);
        else count.put(poppedElement, prevCount - 1);
        if (stacks.get(maxCount).isEmpty()) {
            stacks.remove(maxCount);
            maxCount--;
        }
        return poppedElement;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */