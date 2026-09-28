class Solution {
    private class Box {
        char letter;
        int x;
        int y;

        public Box(char letter, int x, int y) {
            this.letter = letter;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "letter=" + letter +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private Box[][] boxGrid;
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        this.boxGrid = new Box[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                boxGrid[i][j] = new Box(board[i][j], j, i);
        this.board = board;
        this.word = word;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                Set<Box> set = new HashSet<>();
                if (dfs(0, set, i, j)) return true;
            }
        return false;
    }

    private boolean dfs(int wordIndex, Set<Box> currentBoxes,  int i, int j) {
        if (word.length() == wordIndex) return true;
        if (i >= boxGrid.length || j >= boxGrid[0].length
                || i < 0 || j < 0) return false;
        if (boxGrid[i][j].letter == word.charAt(wordIndex)
                && !currentBoxes.contains(boxGrid[i][j])
        ) {
            System.out.println(boxGrid[i][j]);
            currentBoxes.add(boxGrid[i][j]);
            return dfs(wordIndex + 1, new HashSet<>(currentBoxes), i - 1, j)
                    || dfs(wordIndex + 1, new HashSet<>(currentBoxes), i + 1, j)
                    || dfs(wordIndex + 1, new HashSet<>(currentBoxes), i, j - 1)
                    || dfs(wordIndex + 1, new HashSet<>(currentBoxes), i, j + 1);
        } else {
            return false;
        }
    }
}
