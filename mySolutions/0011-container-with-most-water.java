class Solution {
    private int area(int[] height, int l, int r) {
        return (r - l) * Math.min(height[l], height[r]);
    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;

        while(l < r) {
            maxArea = Math.max(maxArea, area(height, l, r));

            if(height[l] <= height[r]) {
                l ++;
            } else {
                r --;
            }
        }

        return maxArea;
    }
}