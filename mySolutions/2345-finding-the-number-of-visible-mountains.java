import java.util.Arrays;

class Solution {
   public int visibleMountains(int[][] peaks) {
      int n = peaks.length;
      for(int i = 0; i < n; i ++) {
         int temp = peaks[i][0];
         peaks[i][0] -= peaks[i][1];
         peaks[i][1] += temp;
      }

      Arrays.sort(peaks, (a, b) -> {
         return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
      });

      int visible = 0;
      int currEnd = Integer.MIN_VALUE;
      for(int i = 0; i < peaks.length; i ++) {
         if(peaks[i][1] > currEnd) {
            currEnd = peaks[i][1];
            if(i + 1 == n
                    || peaks[i][0] != peaks[i + 1][0]
                    || peaks[i][1] != peaks[i + 1][1]) {
               visible ++;
            }
         }
      }
      return visible;
   }
}
