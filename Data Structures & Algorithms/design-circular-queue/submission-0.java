class MyCircularQueue {

    private int[] arr;
    private int start;
    private int end;
    private int capacity;

    public MyCircularQueue(int k) {
        this.arr = new int[k];
        this.start = -1;
        this.end = -1;
        this.capacity = k;
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        if (start==-1) {
            arr[0] = value;
            start = 0;
            end = 0;
        } else {
            end = (end+1)%capacity;
            arr[end] = value;
        }
        return true;
    }

    public boolean deQueue() {
        if (start==-1) return false;
        if (start==end) {
            start = -1;
            end = -1;
        } else {
            start = (start+1)%capacity;
        }
        return true;
    }

    public int Front() {
        if (start==-1) return -1;
        else return arr[start];
    }

    public int Rear() {
        if (end==-1) return -1;
        else return arr[end];
    }

    public boolean isEmpty() {
        if (start==-1) return true;
        else return false;
    }

    public boolean isFull() {
        if (start==-1) return false;
        if ((end+1)%capacity==start) return true;
        else return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */