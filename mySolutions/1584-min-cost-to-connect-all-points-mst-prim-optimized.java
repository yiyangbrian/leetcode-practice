class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int cost = 0;

        int edges = 0;
        int[] visited = new int[n];

        int[] minDist = new int[n];
        minDist[0] = 0;

        for(int i = 1; i < n; i ++) {
            minDist[i] = Integer.MAX_VALUE;
        }

        while(edges < n) {
            int currMinEdge = Integer.MAX_VALUE;
            int currNode = -1;

            for(int node = 0; node < n; node ++) {
                if(visited[node] == 0 && currMinEdge > minDist[node]) {
                    currMinEdge = minDist[node];
                    currNode = node;
                }
            }

            cost += currMinEdge;
            edges ++;
            visited[currNode] = 1;

            for(int nextNode = 0; nextNode < n; nextNode ++) {
                int weight = Math.abs(points[currNode][0] - points[nextNode][0]) + Math.abs(points[currNode][1] - points[nextNode][1]);
                if(visited[nextNode] == 0 && minDist[nextNode] > weight) {
                    minDist[nextNode] = weight;
                }
            }
        }

        return cost;
    }
}
