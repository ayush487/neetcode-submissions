class MinStack {

    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.mainStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty()) minStack.push(val);
        else minStack.push(Math.min(minStack.peek(), val));

    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
