import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        //set bounds
        int up = 0;
        int left = 0;
        int down = matrix.length - 1;
        int right = matrix[0].length - 1;
        int numsMatrix = matrix.length * matrix[0].length;

        while(list.size() < numsMatrix) {

            for(int i = left; i <= right; i ++) {
                list.add(matrix[up][i]);
            }

            for(int i = up + 1; i <= down; i ++) {
                list.add(matrix[i][right]);
            }

            //in a cycle, there will definitely be moving right
            //and moving down, but may not be moving left or up.
            //imagine a matrix with only 1 row or 1 col.
            if(up != down) {
                for(int i = right - 1; i >= left; i --) {
                    list.add(matrix[down][i]);
                }
            }

            if(left != right) {
                for(int i = down - 1; i > up; i --) {
                    list.add(matrix[i][left]);
                }
            }

            up ++;
            left ++;
            down --;
            right --;
        }

        return list;
    }
}