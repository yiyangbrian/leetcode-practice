import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 0;
        for(int i = 0; i < n; i ++) {
            Map<String, Integer> map = new HashMap<>();
            int cnt = 0;
            for(int j = i + 1; j < n; j ++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                String key = slope(x1, y1, x2, y2);
                map.put(key, map.getOrDefault(key, 0) + 1);
                cnt = Math.max(cnt, map.get(key));
            }
            ans = Math.max(ans, cnt + 1);
        }
        return ans;
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    private String slope(int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x1 - x2), dy = Math.abs(y1 - y2);
        int k = gcd(dx, dy);
        String key = Integer.toString(dy / k) + "_" + Integer.toString(dx / k);
        if((x1 < x2 && y1 > y2) || (x1 > x2 && y1 < y2)) {
            return "-" + key;
        }
        return key;
    }
}
