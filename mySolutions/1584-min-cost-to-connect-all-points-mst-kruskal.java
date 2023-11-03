import java.util.PriorityQueue;
import java.util.Queue;

class UnionFind{
    int[] parent;
    int[] weight;

    public UnionFind(int n) {
        parent = new int[n];
        weight = new int[n];
        for(int i = 0; i < n; i ++) {
            parent[i] = i;
            weight[i] = 1;
        }
    }

    public int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return x = find(parent[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY) {
            if(weight[rootX] >= weight[rootY]) {
                parent[rootY] = rootX;
                weight[rootX] += weight[rootY];
            } else {
                parent[rootX] = rootY;
                weight[rootY] += weight[rootX];
            }
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}

class Solution {
    int[][] points;

    private int manhattan(int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }

    public int minCostConnectPoints(int[][] points) {
        this.points = points;
        int n = points.length;
        Queue<int[]> pq = new PriorityQueue<>((edge1, edge2) -> manhattan(edge1[0], edge1[1]) - manhattan(edge2[0], edge2[1]));
        for(int i = 0; i < n; i ++) {
            for(int j = i + 1; j < n; j ++) {
                int[] edge = new int[]{i, j};
                pq.add(edge);
            }
        }

        int count = 0;
        UnionFind ds = new UnionFind(n);
        int ans = 0;

        while(count < n - 1) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = manhattan(x, y);

            if(!ds.isConnected(x, y)) {
                ds.union(x, y);
                ans += dist;
                count ++;
            }
        }

        return ans;
    }
}
