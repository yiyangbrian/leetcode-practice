class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        for(int i = 0; i < 32; i ++) {
            if((left >> i) == (right >> i)) {
                ans = (left >> i) << i;
                break;
            }
        }
        return ans;
    }
}
