import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
        for(int i = 0; i < nums.length; i ++) {
            pq.offer(i);
        }

        int res = nums[pq.poll()];

        for(int i = 0; i < k - 1; i ++) {
            res = nums[pq.poll()];
        }

        return res;

    }
}
