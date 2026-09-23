class Solution {
    private class Task {
        char c;
        int count;
        int cooldown;

        public Task(char c, int count) {
            this.c = c;
            this.count = count;
            this.cooldown = 0;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        if (n==0) return tasks.length;
        Map<Character, Integer> taskCount = new HashMap<>();
        for (char task : tasks) {
            taskCount.put(task, taskCount.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Task> maxHeap = new PriorityQueue<>((t1, t2) -> t2.count - t1.count);
        for (Map.Entry<Character, Integer> entry : taskCount.entrySet()) {
            maxHeap.offer(new Task(entry.getKey(), entry.getValue()));
        }
        Queue<Task> cooldownQueue = new LinkedList<>();
        int cycles = 1;
        Task t = maxHeap.poll();
        t.count--;
        t.cooldown = cycles + n + 1;
        if (t.count != 0) cooldownQueue.offer(t);
        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            cycles++;
            Task ct = cooldownQueue.peek();
            if (ct!=null && ct.cooldown==cycles) {
                maxHeap.offer(ct);
                cooldownQueue.poll();
            }
            if (!maxHeap.isEmpty()) {
                Task t1 = maxHeap.poll();
                t1.count--;
                t1.cooldown = cycles + n + 1;
                if (t1.count != 0) cooldownQueue.offer(t1);
            }
        }
        return cycles;
    }
}
