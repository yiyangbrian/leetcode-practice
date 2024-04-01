class Solution {
   public int jump(int[] nums) {
      int n = nums.length;
      if(n <= 1) return 0;

      int[] steps = new int[n];
      for(int i = n - 2; i >= 0; i --) {

         if(i + nums[i] >= n - 1) {
            steps[i] = 1;
         } else {
            int min = n;
            for(int j = i + 1; j <= i + nums[i]; j ++) {
               min = Math.min(min, steps[j] + 1);
            }
            steps[i] = min;
         }

      }
      return steps[0];
   }
}
