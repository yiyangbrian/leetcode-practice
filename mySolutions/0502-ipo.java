import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<Integer> pqCapital = new PriorityQueue<>((a, b) -> capital[a] - capital[b]);

        for(int i = 0; i < capital.length; i ++) {
            pqCapital.offer(i);
        }

        Queue<Integer> pqProfits = new PriorityQueue<>((a, b) -> b - a);
        int n = 0;
        for(int i = 0; i < k; i ++) {
            while(n < capital.length && capital[pqCapital.peek()] <= w) {
                pqProfits.offer(profits[pqCapital.poll()]);
                n ++;
            }
            if(pqProfits.isEmpty()) {
                break;
            }
            w += pqProfits.poll();
        }
        return w;
    }
}
