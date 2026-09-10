class Solution {
   public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newArr = new int[m+n];
        int i = 0;
        int j = 0;
        while(i<m && j<n) {
            if (nums1[i] < nums2[j]) newArr[i+j] = nums1[i++];
            else newArr[i+j] = nums2[j++];
        }
        while(i<m) newArr[i+j] = nums1[i++];
        while(j<n) newArr[i+j] = nums2[j++];
        for (int k = 0; k < nums1.length; k++) {
            nums1[k] = newArr[k];
        }
    }
}