class Solution {
    class Projects {
        int profits;
        int capital;
        public Projects(int profits, int capital) {
            this.profits = profits;
            this.capital = capital;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Projects[] projects = new Projects[profits.length];
        for (int i=0;i<profits.length;i++) {
            projects[i] = new Projects(profits[i], capital[i]);
        }
        Arrays.sort(projects, (p1, p2) -> p1.capital - p2.capital);
        PriorityQueue<Projects> heap = new PriorityQueue<>((p1, p2) -> p2.profits - p1.profits);
        int projectInserted = 0;
        while(projectInserted<projects.length && projects[projectInserted].capital<=w) heap.offer(projects[projectInserted++]);
        while (!heap.isEmpty() && k>0) {
            Projects currProject = heap.poll();
            w += currProject.profits;
            k--;
            while(projectInserted<projects.length && projects[projectInserted].capital<=w) heap.offer(projects[projectInserted++]);
        }
        return w;
    }
}