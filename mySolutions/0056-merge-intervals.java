import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int[] interval : intervals) {
            System.out.println(interval[0] + ", " + interval[1]);
        }

        int len = intervals.length;
        List<int[]> res = new ArrayList<>();

        int left = 0, right = 1;

        while(right < len * 2) {

            int bound = intervals[right / 2][1];
            while(right < len * 2 - 2 &&
                    intervals[(right + 1) / 2][0] <= bound) {
                bound = Math.max(bound, intervals[(right + 1) / 2][1]);
                right += 2;
            }
            int[] cut = new int[]{intervals[left / 2][0], bound};
            res.add(cut);
            left = right + 1;
            right += 2;
        }

        return res.toArray(new int[res.size()][]);

    }
}
