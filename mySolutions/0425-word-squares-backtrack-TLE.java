import java.util.ArrayList;
import java.util.List;

class Solution {
   String[] words;
   List<List<String>> result;
   int dimension;

   private void backtrack(int row, List<String> partial) {
      if(row == dimension) {
         result.add(new ArrayList<>(partial));
         return;
      }

      for(String word : words) {
         if(isLegal(row, partial, word)) {
            partial.add(word);
            backtrack(row + 1, partial);
            partial.remove(partial.size() - 1);
         }
      }
   }

   private boolean isLegal(int row, List<String> partial, String word) {

      for(int i = 1; i < row + 1; i ++) {
         String horizontal;
         if(i == row) {
            horizontal = word.substring(0, row + 1);
         } else {
            horizontal = partial.get(i).substring(0, row + 1);
         }
         String vertical = "";
         for(int j = 0; j < row; j ++) {
            vertical += partial.get(j).charAt(i);
         }
         vertical += word.charAt(i);
         if(!horizontal.equals(vertical)) {
            return false;
         }
      }

      return true;
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
