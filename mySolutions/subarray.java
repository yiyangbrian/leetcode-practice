import java.util.Arrays;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n];
        sums[0] = nums[0];

        for(int i = 1; i < n; i ++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        for(int i = 0; i < n; i ++) {
            int toFind = target + sums[i] - nums[i];
            int bound = Arrays.binarySearch(sums, toFind);
            if(bound != - (n + 1)) {
                bound = bound < 0 ? (- bound - 1) : bound;
                ans = Math.min(ans, bound - i + 1);
            }
        }

        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}
