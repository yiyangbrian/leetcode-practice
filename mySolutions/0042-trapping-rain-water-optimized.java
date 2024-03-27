class Solution {
   public int trap(int[] height) {

      // scan from left to right
      int peak = 0; //  update it
      int n = height.length;
      int sum = 0;

      for(int i = 1; i < n; i ++) {
         if(height[i] < height[peak]) {
            sum += height[peak] - height[i];
         } else {
            peak = i;
         }
      }

      int rightPeak = n - 1;

      for(int i = n - 1; i > peak; i --) {
         if(height[i] > height[rightPeak]) {
            rightPeak = i;
         }
         sum -= height[peak] - height[rightPeak];
      }
      return sum;
   }
}
