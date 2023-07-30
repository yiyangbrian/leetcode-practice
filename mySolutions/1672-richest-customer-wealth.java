class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealthSoFar = 0;
        for(int[] account : accounts){
            int currWealth = 0;
            for(int money : account){
                currWealth += money;
            }
            maxWealthSoFar = Math.max(maxWealthSoFar, currWealth);
        }
        return maxWealthSoFar;
    }
}
