import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<Character, String> map = new HashMap<>(){
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    List<String> combinations = new ArrayList<>();
    StringBuilder combination = new StringBuilder();

    private void backtrack(String digits, int index) {
        if(combination.length() == digits.length()) {
            combinations.add(combination.toString());
            return;
        }

        String currString = map.get(digits.charAt(index));

        for(int i = 0; i < currString.length(); i ++) {
            combination.append(currString.substring(i, i + 1));
            backtrack(digits, index + 1);
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return combinations;
        }
        backtrack(digits, 0);
        return combinations;
    }
}