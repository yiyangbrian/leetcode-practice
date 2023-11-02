import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Deque<Integer> queue = new ArrayDeque<>();
        int[] marked = new int[n];
        int count = 0;
        for(int i = 0; i < n; i ++) {

            if(marked[i] == 0) {
                queue.offer(i);
                while(!queue.isEmpty()) {
                    int cur = queue.poll();
                    marked[cur] = 1;
                    for(int j = 0; j < n; j ++) {
                        if(isConnected[cur][j] == 1 && marked[j] == 0) {
                            queue.offer(j);
                        }
                    }
                }
                count ++;
            }

        }
        return count;
    }
}
