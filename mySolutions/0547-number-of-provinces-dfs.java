class Solution {
    int n;
    int[][] isConnected;
    int[] visited;

    private void dfs(int i) {

        visited[i] = 1;

        for(int j = 0; j < n; j ++) {
            if(isConnected[i][j] == 1 && visited[j] == 0) {
                dfs(j);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        this.isConnected = isConnected;
        n = isConnected.length;
        this.visited = new int[n];
        int count = 0;

        for(int i = 0; i < n; i ++) {
            if(visited[i] == 0) {
                dfs(i);
                count ++;
            }
        }
        return count;
    }
}
