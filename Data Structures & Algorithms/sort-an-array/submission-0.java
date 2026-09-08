class Solution {
   public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    void mergeSort(int[] nums, int l, int r) {
        if (l<r) {
            int m = (l+r) / 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m+1, r);

            merge(nums, l,m,r);
        }
    }

    void merge(int[] nums, int l, int m, int r) {
        int s1 = m - l + 1;
        int s2 = r - m;
        int[] arr1 = new int[s1];
        int[] arr2 = new int[s2];

        for (int i=0;i<s1;i++) {
            arr1[i] = nums[i + l];
        }
        for (int i=0;i<s2;i++) {
            arr2[i] = nums[m+1+i];
        }
        int i=0, j=0;
        while(i<s1 && j<s2) {
            if (arr1[i]<arr2[j]) nums[l++] = arr1[i++];
            else nums[l++] = arr2[j++];
        }
        while (i < s1) nums[l++] = arr1[i++];
        while (j < s2) nums[l++] = arr2[j++];
    }
}