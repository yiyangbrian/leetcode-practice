class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] store = new int[n];

        int peakLeft = 0;

        for(int i = 1; i < n; i ++) {
            if(height[i] > height[peakLeft]) {
                peakLeft = i;
            } else {
                store[i] = height[peakLeft] - height[i];
            }
        }

        int peakRight = n - 1;
        store[n - 1] = 0;

        for(int i = n - 2; i > peakLeft; i --) {
            if(height[i] > height[peakRight]) {
                store[i] = 0;
                peakRight = i;
            } else {
                store[i] = height[peakRight] - height[i];
            }
        }

        int sum = 0;

        for(int water : store) {
            sum += water;
        }

        return sum;
    }
}
