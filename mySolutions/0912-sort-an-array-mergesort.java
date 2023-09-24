import java.util.Arrays;

class Solution {
    private int[] merge(int[] arrayLeft, int[] arrayRight) {
        int curseLeft = 0, curseRight = 0;
        int curseRes = 0;
        int[] res = new int[arrayLeft.length + arrayRight.length];
        while(curseLeft < arrayLeft.length && curseRight < arrayRight.length) {
            if(arrayLeft[curseLeft] <= arrayRight[curseRight]) {
                res[curseRes] = arrayLeft[curseLeft];
                curseRes ++;
                curseLeft ++;
            } else {
                res[curseRes] = arrayRight[curseRight];
                curseRes ++;
                curseRight ++;
            }
        }
        if(curseLeft == arrayLeft.length) {
            for( ; curseRight < arrayRight.length; curseRight ++) {
                res[curseRes] = arrayRight[curseRight];
                curseRes ++;
            }
        }
        else if(curseRight == arrayRight.length) {
            for( ; curseLeft < arrayLeft.length; curseLeft ++) {
                res[curseRes] = arrayLeft[curseLeft];
                curseRes ++;
            }
        }
        return res;
    }

    public int[] sortArray(int[] nums) {
        if(nums.length <= 1) {
            return nums;
        }
        int i = nums.length / 2;
        int[] sortedLeft = sortArray(Arrays.copyOfRange(nums, 0, i));
        int[] sortedRight = sortArray(Arrays.copyOfRange(nums, i, nums.length));
        return merge(sortedLeft, sortedRight);
    }
}
