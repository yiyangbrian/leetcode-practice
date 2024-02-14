import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
   String[] words;
   List<List<String>> result;
   int dimension;

   private void backtrack(int row, List<String> partial) {
      if(row == dimension) {
         result.add(new ArrayList<>(partial));
         return;
      }

      for(String word : wordsOfPrefix(row, partial)) {

         partial.add(word);
         backtrack(row + 1, partial);
         partial.remove(partial.size() - 1);

      }
   }

   private Set<String> wordsOfPrefix(int row, List<String> partial) {

      Set<String> set = new HashSet<>();
      String prefix = "";
      for(int i = 0; i < row; i ++) {
         prefix += partial.get(i).charAt(row);
      }
      for(String word : words) {
         if(word.substring(0, row).equals(prefix)) {
            set.add(word);
         }
      }
      return set;
   }


   public List<List<String>> wordSquares(String[] words) {
      dimension = words[0].length();
      this.words = words;
      result = new ArrayList<>();

      for(String word : words) {
         List<String> partial = new ArrayList<>();
         partial.add(word);
         backtrack(1, partial);
      }

      return result;
   }
}
