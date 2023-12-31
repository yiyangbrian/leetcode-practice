class UnionFind {

    int[] parent;
    int[] weight;
    int islands;

    public UnionFind(int n) {
        parent = new int[n];
        weight = new int[n];
        islands = n;

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
            islands --;
        }
    }

    public int getIslands() {
        return islands;
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind ds = new UnionFind(n);
        for(int i = 0; i < n; i ++) {
            for(int j = i + 1; j < n; j ++) {
                if(isConnected[i][j] == 1) {
                    ds.union(i, j);
                }
            }
        }
        return ds.getIslands();
    }
}
