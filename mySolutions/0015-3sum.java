import java.util.ArrayList;
import java.util.List;

class Solution {
    private int sum(int[] nums, int i, int m, int j) {
        return nums[i] + nums[m] + nums[j];
    }

    private void addToList(List<List<Integer>> output, int[] nums, int i, int m, int j){
        List<Integer> section = new ArrayList<>();
        section.add(nums[i]);
        section.add(nums[m]);
        section.add(nums[j]);
        output.add(section);
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        int m = i + 1;

        while(m < j) {

            if(sum(nums, i, m, j) > 0 && j > m) {
                j --;
                continue;
            }

            if(sum(nums, i, m, j) == 0) {
                addToList(output, nums, i, m, j);
                j --;
                while(m < j && nums[j + 1] == nums[j]) {
                    j --;
                }
            }

            m ++;
            while(m < j && nums[m] == nums[m - 1]) {
                m ++;
            }

            while(sum(nums, i, m, j) > 0 && j > m) {
                j --;
            }

            if(m >= j) {
                j = nums.length - 1;
                i ++;
                while(nums[i - 1] == nums[i] && i < j - 1) {
                    i ++;
                }
                m = i + 1;
            }
        }
        return output;
    }
}