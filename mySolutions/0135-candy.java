class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        for(int i = 0; i < n; i ++) {
            if(i != 0 && ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        int sum = candies[n - 1];

        for(int i = n - 2; i >= 0; i --) {
            if(ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }

            sum += candies[i];
        }

        return sum;
    }
}