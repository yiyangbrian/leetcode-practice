class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int i = 0, gasLeft = 0, gross = 0, answer = 0;
        while(i < gas.length) {
            gasLeft += gas[i] - cost[i];
            gross += gas[i] - cost[i];
            i ++;
            if(gasLeft < 0) {
                gasLeft = 0;
                answer = i;
            }
        }
        return gross >= 0 ? answer : -1;
    }
}