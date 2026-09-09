class NumMatrix {

    private int[][] matrix;
    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.prefixSum = getPrefixSum(matrix);
    }


    public int sumRegion(int row1, int col1, int row2, int col2) {
        int s = prefixSum[row2][col2];
        s -= getSum(row1 - 1, col2);
        s -= getSum(row2, col1 - 1);
        s += getSum(row1 - 1, col1 - 1);
        return s;
    }

    private int getSum(int i, int j) {
        if (i < 0 || j < 0) return 0;
        else return prefixSum[i][j];
    }

    private int[][] getPrefixSum(int[][] matrix) {
        int[][] prefixSum = new int[matrix.length][matrix[0].length];
        int rows = matrix[0].length;
        int cols = matrix.length;
        prefixSum[0][0] = matrix[0][0];
        for (int i = 1; i < rows; i++) {
            prefixSum[0][i] = prefixSum[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < cols; i++) {
            prefixSum[i][0] = prefixSum[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < cols; i++) {
            for (int j = 1; j < rows; j++) {
                prefixSum[i][j] = matrix[i][j] + prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1];
            }
        }
        return prefixSum;
    }

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */