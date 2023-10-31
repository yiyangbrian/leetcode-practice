class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int pivot, left = 0, right = m * n - 1;
        while(left <= right) {
            pivot = left + (right - left) / 2;
            int row = pivot / n, col = pivot % n;
            if(matrix[row][col] == target) return true;
            if(matrix[row][col] < target) left = pivot + 1;
            else right = pivot - 1;
        }
        return false;
    }
}
