class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        int[] closestElement = {0, Math.abs(x - arr[0])};
        for (int i = 1;i<arr.length;i++) {
            if (Math.abs(x - arr[i])<closestElement[1]) {
                closestElement[0] = i;
                closestElement[1] = Math.abs(x - arr[i]);
            }
        }
        int l = closestElement[0], r = closestElement[0];
        while(r - l + 1 < k) {
            if (l==0) r++;
            else if (r==arr.length - 1) l--;
            else if (Math.abs(x - arr[l-1]) <= Math.abs(x - arr[r+1])) l--;
            else r++;
        }

        for (int i=l;i<=r;i++) {
            result.add(arr[i]);
        }

        return result;
    }
}