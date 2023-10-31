import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<List<Integer>> permutations = new ArrayList<>();
    List<Integer> permutation = new ArrayList<>();

    private void backtrack(int[] nums) {

        if(permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for(int i = 0; i < nums.length; i ++) {
            if(!permutation.contains(nums[i])) {
                permutation.add(nums[i]);
                backtrack(nums);
                permutation.remove(permutation.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return permutations;
    }
}
