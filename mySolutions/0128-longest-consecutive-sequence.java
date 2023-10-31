import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for(int num : set) {
            if(!set.contains(num - 1)) {
                int temp = num;
                while(set.contains(temp + 1)) {
                    temp ++;
                }
                longest = Math.max(longest, temp - num + 1);
            }
        }

        return longest;
    }
}
