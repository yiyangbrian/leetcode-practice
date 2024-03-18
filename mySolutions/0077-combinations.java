import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> combinations = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();

    private void backtrack(int start, int n, int k) {
        if(combination.size() == k) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for(int i = start; i <= n; i ++) {
            combination.add(i);
            backtrack(i + 1, n, k);
            combination.remove(combination.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return combinations;
    }
}