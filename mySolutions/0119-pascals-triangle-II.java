import java.util.ArrayList;
import java.util.List;

class Solution {
    private int getNum(int row, int idx, int[][] memo) {
        if(row == idx || idx == 0) {
            return 1;
        }
        if(memo[row][idx] > 1) {
            return memo[row][idx];
        }

        memo[row][idx] = getNum(row - 1, idx - 1, memo) + getNum(row - 1, idx, memo);

        return memo[row][idx];
    }

    public List<Integer> getRow(int rowIndex) {
        int[][] memo = new int[rowIndex + 1][rowIndex + 1];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < rowIndex + 1; i ++) {
            list.add(getNum(rowIndex, i, memo));
        }
        return list;
    }
}
