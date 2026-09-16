class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (matrix[0][0] > target || matrix[rows - 1][cols - 1] < target) return false;
        int expectedRow = getExpectedRow(matrix, target, rows, cols);
        if (expectedRow==-1) return false;
        int idx = binarySearch(matrix[expectedRow], target, 0, cols - 1);
        if (idx == -1) return false;
        return true;
    }

    private int binarySearch(int[] nums, int target, int i, int j) {
        if (i > j) return -1;
        int mid = i + (j - i) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) return binarySearch(nums, target, i, mid - 1);
        else return binarySearch(nums, target, mid + 1, j);
    }

    private int getExpectedRow(int[][] matrix, int target, int rows, int cols) {
        int ll = 0;
        int ul = rows - 1;
        while (true) {
            int mid = ll + (ul - ll) / 2;
            if (mid > 0 && target<matrix[mid][0] && target > matrix[mid-1][cols-1])
                return -1;
            if (matrix[mid][0] <= target) {
                if (matrix[mid][cols - 1] >= target) return mid;
                else ll = mid + 1;
            } else ul = mid - 1;
        }
    }
}
