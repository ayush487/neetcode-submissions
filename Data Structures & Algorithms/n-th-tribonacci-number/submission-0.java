class Solution {
    public int tribonacci(int n) {
        if (n==0) return 0;
        if (n==1 || n==2) return 1;
        int last1 = 0;
        int last2 = 1;
        int last3 = 1;
        int ans = last1+last2+last3;
        for (int i=3;i<=n;i++) {
            ans = last1+last2+last3;
            last1 = last2;
            last2 = last3;
            last3 = ans;
        }
        return ans;
    }
}