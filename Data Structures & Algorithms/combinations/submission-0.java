class Solution {
        private List<List<Integer>> mainlist;
    public List<List<Integer>> combine(int n, int k) {
        mainlist = new ArrayList<>();
        for (int i=1;i<=n-k+1;i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            dfs(n, k, list, i+1);
        }
        return mainlist;
    }

    private void dfs(int n, int k, List<Integer> currList, int currIdx) {
        if (currList.size()==k) {
            mainlist.add(currList);
            return;
        }
        for (int i=currIdx;i<=n;i++) {
            List<Integer> listCopy = new ArrayList<>(currList);
            listCopy.add(i);
            dfs(n, k, listCopy, i+1);
        }
    }
}