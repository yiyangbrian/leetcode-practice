class Solution {
    //turn indicates the times we rotate of each circle layer
    private void circleRotate(int[][] matrix, int turn) {
        int len = matrix[0].length;
        for(int i = turn - 1; i < len - turn; i ++) {
            int temp2 = matrix[i][len - turn];
            matrix[i][len - turn] = matrix[turn - 1][i];

            int temp3 = matrix[len - turn][len - i - 1];
            matrix[len - turn][len - i - 1] = temp2;

            int temp4 = matrix[len - i - 1][turn - 1];
            matrix[len - i - 1][turn - 1] = temp3;

            matrix[turn - 1][i] = temp4;
        }
    }

    public void rotate(int[][] matrix) {
        //total times to rotate
        int times = matrix[0].length / 2;
        for(int turn = 1; turn <= times; turn ++) {
            circleRotate(matrix, turn);
        }
    }
}
