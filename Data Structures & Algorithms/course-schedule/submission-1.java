class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> require = new HashMap<>();
        Set<Integer> canDo = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            require.computeIfAbsent(prerequisites[i][0], k -> new ArrayList<Integer>())
                    .add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!require.containsKey(i)) {
                canDo.add(i);
                continue;
            }
            if (canDo.contains(i)) continue;
            for (int thisRequiredCourse : require.get(i)) {
                Set<Integer> alreadyPendingCourses = new HashSet<>();
                alreadyPendingCourses.add(i);
                boolean isThisCourseViable = dfs(require, canDo, alreadyPendingCourses, thisRequiredCourse);
                if (!isThisCourseViable) return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> require, Set<Integer> canDo, Set<Integer> alreadyPending, int course) {
        if (!require.containsKey(course) || canDo.contains(course)) return true;

        if (alreadyPending.contains(course)) return false;

        alreadyPending.add(course);

        boolean ans = true;
        for (int thisRequiredCourse : require.get(course)) {
            ans = dfs(require, canDo, alreadyPending, thisRequiredCourse);
            if (!ans) return false;
        }
        canDo.add(course);
        return true;

    }
}
