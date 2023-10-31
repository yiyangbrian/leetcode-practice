class Solution {
    int count = 0;
    int n;

    private void backtrack(int row, int[][] queens) {
        if(row == n) {
            count ++;
            return;
        }
        for(int col = 0; col < n; col ++) {
            if(isLegal(row, col, queens)) {
                queens[row][col] = 1;
                backtrack(row + 1, queens);
                queens[row][col] = 0;
            }
        }
    }

    private boolean isLegal(int row, int col, int[][] queens) {
        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < n; j ++) {
                if(queens[i][j] == 1) {
                    if(row - col == i - j) return false;
                    if(col == j) return false;
                    if(row + col == i + j) return false;
                }
            }
        }
        return true;
    }

    public int totalNQueens(int n) {
        this.n = n;
        int[][] queens = new int[n][n];
        backtrack(0, queens);
        return count;
    }
}
