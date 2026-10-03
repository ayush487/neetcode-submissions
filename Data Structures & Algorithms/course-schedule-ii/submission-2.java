class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> require = new HashMap<>();
        Set<Integer> canDo = new HashSet<>();
        List<Integer> order = new ArrayList<>();
        Set<Integer> orderSet = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            require.computeIfAbsent(prerequisites[i][0], k -> new ArrayList<Integer>())
                    .add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (canDo.contains(i))
                continue;
            if (!require.containsKey(i)) {
                canDo.add(i);
                if (!orderSet.contains(i)) {
                    order.add(i);
                    orderSet.add(i);
                }
                continue;
            }
            for (int thisRequiredCourse : require.get(i)) {
                Set<Integer> alreadyPendingCourses = new HashSet<>();
                alreadyPendingCourses.add(i);
                Queue<Integer> queue = new LinkedList<>();
                boolean isThisCourseViable = dfs(require, canDo, alreadyPendingCourses, queue, thisRequiredCourse);

                if (isThisCourseViable) {
                    while (!queue.isEmpty()) {
                        int nnnn = queue.poll();
                        if (!orderSet.contains(nnnn)) {
                            order.add(nnnn);
                            orderSet.add(nnnn);
                        }
                    }
                } else return new int[]{};
            }
            if (!orderSet.contains(i)) {
                orderSet.add(i);
                order.add(i);
            }
        }

        int[] orderArr = new int[order.size()];
        for (int i = 0; i < orderArr.length; i++) {
            orderArr[i] = order.get(i);
        }
        return orderArr;
    }

    private boolean dfs(Map<Integer, List<Integer>> require, Set<Integer> canDo, Set<Integer> alreadyPending, Queue<Integer> queue, int course) {
        if (canDo.contains(course)) return true;

        if (!require.containsKey(course)) {
            canDo.add(course);
            queue.add(course);
            return true;
        }

        if (alreadyPending.contains(course)) return false;

        alreadyPending.add(course);

        boolean ans = true;
        for (int thisRequiredCourse : require.get(course)) {
            ans = dfs(require, canDo, alreadyPending, queue, thisRequiredCourse);
            if (!ans) return false;
        }
        canDo.add(course);
        queue.offer(course);
        return true;

    }
}