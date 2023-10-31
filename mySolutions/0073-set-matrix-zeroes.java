import java.util.ArrayList;
import java.util.List;

class Solution {
    //direction = 0, set the row zeroes
    //direction = 1, set the col zeroes
    private void zeroIt(int[][] matrix, int direction, int idx) {
        int colLen = matrix.length;
        int rowLen = matrix[0].length;
        if(direction == 0) {
            //impropriate to use iterator, for(num : nums), the
            //num is a temp variable, we cannot change the matrix with it
            for(int i = 0; i < rowLen; i ++) {
                matrix[idx][i] = 0;
            }
        } else if(direction == 1) {
            for(int i = 0; i < colLen; i ++) {
                matrix[i][idx] = 0;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        List<Integer> rowsMarked = new ArrayList<>();
        List<Integer> colsMarked = new ArrayList<>();

        //investigate zeros in matrix
        for(int row = 0; row < matrix.length; row ++) {
            for(int col = 0; col < matrix[row].length; col ++) {
                if(matrix[row][col] == 0) {
                    rowsMarked.add(row);
                    colsMarked.add(col);
                }
            }
        }

        for(int rowMarked : rowsMarked) {
            zeroIt(matrix, 0, rowMarked);
        }

        for(int colMarked : colsMarked) {
            zeroIt(matrix, 1, colMarked);
        }
    }
}
