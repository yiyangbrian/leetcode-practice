class Solution {
    char[][] board;
    int ROWS;
    int COLS;

    private boolean backtrack(int row, int col, String word, int index) {
        if(index >= word.length()) {
            return true;
        }

        if(row < 0 || row == ROWS || col < 0 || col == COLS || board[row][col] != word.charAt(index)) {
            return false;
        }

        board[row][col] = '#';

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};

        for(int d = 0; d < 4; d ++) {
            if(backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1)) {
                return true;
            }
        }

        board[row][col] = word.charAt(index);
        return false;

    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for(int row = 0; row < ROWS; row ++) {
            for(int col = 0; col < COLS; col ++) {
                if(backtrack(row, col, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }
}