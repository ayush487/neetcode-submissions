class Solution {
    class Task {
        int enqueueTime;
        int processingTime;
        int index;

        public Task(int enqueueTime, int processingTime, int index) {
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
            this.index = index;
        }
    }

    public int[] getOrder(int[][] tasks) {
        int[] order = new int[tasks.length];
        for (int i=0;i< tasks.length;i++) order[i] = -1;
        PriorityQueue<Task> heap = new PriorityQueue<>((t1, t2) -> {
           if (t1.processingTime > t2.processingTime) return 1;
           else if (t1.processingTime < t2.processingTime) return -1;
           else {
               if (t1.index > t2.index) return -1;
               else return 1;
           }
        });
        Task[] tasksArr = new Task[tasks.length];
        for (int i=0;i<tasks.length;i++) {
            Task t = new Task(tasks[i][0], tasks[i][1], i);
            tasksArr[i] = t;
        }
        Arrays.sort(tasksArr, (t1, t2) -> t1.enqueueTime - t2.enqueueTime);
        int timestamp = 0;
        int tasksProcessed = 0;
        boolean didProccessed = false;
        int i=0;
        while(i<tasksArr.length) {
            while (i<tasksArr.length && tasksArr[i].enqueueTime <= timestamp) {
                heap.offer(tasksArr[i]);
                i++;
            }
            if (!heap.isEmpty()) {
                Task tk = heap.poll();
                timestamp += tk.processingTime;
                didProccessed = true;
                order[tasksProcessed++] = tk.index;
            }
            if (!didProccessed) {
                timestamp++;
            }
            didProccessed = false;
        }
        while(!heap.isEmpty()) {
            Task tk = heap.poll();
            timestamp += tk.processingTime;
            order[tasksProcessed++] = tk.index;
        }
        return order;
    }
}