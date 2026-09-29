class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) return false;
        int length = sum / 4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int[] sides = new int[4];
        return dfs(matchsticks, sides, length, 0);
    }

    private boolean dfs(int[] matchSticks, int[] sides, int length, int index) {
        if (index == matchSticks.length) return true;

        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchSticks[index] <= length) {
                sides[i] += matchSticks[index];
                if(dfs(matchSticks, sides, length, index+1)) return true;
                sides[i]-=matchSticks[index];
            }
            if (sides[i]==0) break;
        }
        return false;

    }

    private void reverse(int[] matchsticks) {
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
    }
}