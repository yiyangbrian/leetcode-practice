class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while(digits[i] + 1 == 10) {
            digits[i] = 0;
            i = i - 1;
            if(i == -1) {
                int[] arr = new int[digits.length + 1];
                arr[0] = 1;
                for(int j = 1; i < arr.length; i ++) {
                    arr[j] = 0;
                }
                return arr;
            }
        }
        digits[i] += 1;

        return digits;
    }
}
