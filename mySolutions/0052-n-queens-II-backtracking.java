import java.util.Arrays;

class Solution {


    int count = 0;

    // n -> n x n, row -> the current cow being dealing with

    private void dfs(int n, int row, int[] queens) {
        if(row == n) {
            count ++;
            return;
        }
        for(int i = 0; i < n; i ++) {
            if(isLegal(row, i, queens)) {
                queens[row] = i;
                dfs(n, row + 1, queens);
                queens[row] = -1;
            }
        }
    }

    private boolean isLegal(int row, int col, int[] queens) {
        if(row == 0) {
            return true;
        }
        for(int i = 0; i < row; i ++) {
            if(queens[i] - i == col - row) return false;
            if(queens[i] == col) return false;
            if(queens[i] + i == col + row) return false;
        }
        return true;
    }

    public int totalNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        dfs(n, 0, queens);
        return count;
    }
}
