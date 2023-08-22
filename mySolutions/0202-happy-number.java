import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        //Either the sum of digit squares will lead to
        //a cycle or 1, the sum will never increment
        //indifinitely (e.g. 999 -> 243, 9999 -> 324),
        //meaning that even we loop 1000 times, we will
        //always end up with a number where we start from.

        while(n != 1) {
            int sum = 0;
            while(n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;

            if(set.contains(n)) {
                return false;
            }

            set.add(n);
        }
        return true;
    }
}