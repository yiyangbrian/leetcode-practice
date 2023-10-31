import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);

        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;

        for(int i = 0; i < Math.min(m, k); i ++) {
            pq.offer(new int[]{i, 0});
        }

        while(k-- > 0 && !pq.isEmpty()) {
            int[] idxPair = pq.poll();
            ans.add(new ArrayList<>(Arrays.asList(nums1[idxPair[0]], nums2[idxPair[1]])));
            if(idxPair[1] + 1 < n) {
                pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
            }
        }
        return ans;
    }
}
