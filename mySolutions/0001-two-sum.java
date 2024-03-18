import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i ++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }

        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;

        int[] ans = new int[2];

        while(left < right) {
            if(nums[left] + nums[right] == target) {
                ans[0] = map.get(nums[left]).get(0);
                map.get(nums[left]).remove(0);
                ans[1] = map.get(nums[right]).get(0);
                break;
            } else if(nums[left] + nums[right] < target) {
                left ++;
            } else {
                right --;
            }
        }

        return ans;

    }
}
