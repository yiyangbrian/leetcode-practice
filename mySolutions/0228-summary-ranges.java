import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        int left = 0, right = 0;


        while(right < nums.length) {

            while(right < nums.length - 1 && nums[right + 1] == nums[right] + 1) {
                right ++;
            }
            StringBuilder sb = new StringBuilder();
            if(left == right) {
                sb.append(nums[left]);
            } else {
                sb.append(nums[left] + "->" + nums[right]);
            }
            ans.add(sb.toString());

            right ++;
            left = right;
        }

        return ans;
    }
}
