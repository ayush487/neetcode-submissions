class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            char[] arr = getArr(board, i);
            if (containsDuplicate(arr)) return false;
            if (containsDuplicate(board[i])) return false;
        }

        for (int i=0;i<9;i+=3) {
            for (int j=0;j<9;j+=3) {
                char[][] miniBoard = getMatrix(board, i, j, 3);
                if (containsDuplicate(miniBoard)) return false;
            }
        }

        return true;
    }

    private char[][] getMatrix(char[][] board, int i, int j, int size) {
        char[][] matrix = new char[size][size];
        for (int ii=0;ii<size;ii++) {
            for (int jj=0;jj<size;jj++) {
                matrix[ii][jj] = board[i+ii][j+jj];
            }
        }
        return matrix;
    }

    private char[] getArr(char[][] board, int row) {
        char[] arr = new char[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = board[i][row];
        }
        return arr;
    }

    private boolean containsDuplicate(char[] arr) {
        boolean[] boolArr = new boolean[10];
        for (char c : arr) {
            if (c == '.') continue;
            int n = Integer.parseInt(c + "");
            if (boolArr[n]) return true;
            boolArr[n] = true;
        }
        return false;
    }

    private boolean containsDuplicate(char[][] arr) {
        boolean[] boolArr = new boolean[10];
        for (char[] ar : arr) {
            for (char c : ar) {
                if (c == '.') continue;
                int n = Integer.parseInt(c + "");
                if (boolArr[n]) return true;
                boolArr[n] = true;
            }
        }
        return false;
    }
}
