import java.util.Arrays;

class Solution {

    public int findMinArrowShots(int[][] points) {

        if(points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int num = 1;
        int end = points[0][1];

        for(int[] point : points) {
            if(point[0] <= end) {
                end = Math.min(end, point[1]);
            } else {
                end = point[1];
                num ++;
            }
        }

        return num;
    }
}
