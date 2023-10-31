import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> combinations = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();
    int sum = 0;

    private void backtrack(int[] candidates, int target, int index) {
        if(sum == target) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        if(sum > target) {
            return;
        }

        for(int i = index; i < candidates.length; i ++) {
            combination.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, target, i);
            combination.remove(combination.size() - 1);
            sum -= candidates[i];
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return combinations;
    }
}
