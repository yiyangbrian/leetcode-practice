class UnionFind {
    int[] parent;
    int[] weight;
    int n;
    boolean noCycle;

    public UnionFind(int n) {
        noCycle = true;
        parent = new int[n];
        weight = new int[n];
        this.n = n;
        for(int i = 0; i < n; i ++) {
            parent[i] = i;
            weight[i] = 1;
        }
    }

    public int find(int x) {
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
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
        } else {
            noCycle = false;
        }
    }

    public boolean isValidTree() {
        if(!noCycle) {
            return false;
        } else {
            for(int i = 1; i < n; i ++) {
                if(find(i) != find(i - 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {

        UnionFind ds = new UnionFind(n);
        for(int[] edge : edges) {
            ds.union(edge[0], edge[1]);
        }
        return ds.isValidTree();
    }
}
