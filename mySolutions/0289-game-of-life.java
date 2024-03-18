class Solution {
    private int checkNeighbors(int[][] board, int row, int col) {
        int liveNums = 0;
        for(int i = row - 1; i <= row + 1; i ++) {
            for(int j = col - 1; j <= col + 1; j ++) {
                liveNums += isValidLive(board, i, j);
            }
        }

        return liveNums - isValidLive(board, row, col);

    }

    private int isValidLive(int[][] board, int row, int col) {
        int rowLen = board.length;
        int colLen = board[0].length;

        if(row >= 0 && row < rowLen
                && col >= 0 && col < colLen
                && board[row][col] == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public void gameOfLife(int[][] board) {
        int[][] result = new int[board.length][board[0].length];

        for(int row = 0; row < board.length; row ++) {
            for(int col = 0; col < board[row].length; col ++) {
                int neighbors = checkNeighbors(board, row, col);
                if(board[row][col] == 1) {
                    if(neighbors < 2 || neighbors > 3) {
                        result[row][col] = 0;
                    } else if(neighbors == 2 || neighbors == 3) {
                        result[row][col] = 1;
                    }
                } else if(board[row][col] == 0) {
                    if(neighbors == 3) {
                        result[row][col] = 1;
                    } else {
                        result[row][col] = 0;
                    }
                }
            }
        }

        for(int row = 0; row < board.length; row ++) {
            for(int col = 0; col < board[row].length; col ++) {
                board[row][col] = result[row][col];
            }
        }

    }
}
