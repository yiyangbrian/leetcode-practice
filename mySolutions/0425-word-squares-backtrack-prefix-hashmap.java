import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
   String[] words;
   List<List<String>> result;
   int dimension;
   Map<String, List<String>> prefixHashTable;

   private void buildPrefixHashTable() {
      prefixHashTable = new HashMap<>();
      for(String word : words) {
         for(int i = 1; i < dimension; i ++) {
            String prefix = word.substring(0, i);
            List<String> wordList = prefixHashTable.get(prefix);
            if(wordList == null) {
               wordList = new ArrayList<>();
               wordList.add(word);
               prefixHashTable.put(prefix, wordList);
            } else {
               wordList.add(word);
            }
         }
      }
   }

   private List<String> getWordsWithPrefix(String prefix) {
      List<String> wordList = prefixHashTable.get(prefix);
      return wordList != null ? wordList : new ArrayList<>();
   }

   private void backtrack(int row, List<String> partial) {
      if(row == dimension) {
         result.add(new ArrayList<>(partial));
         return;
      }

      StringBuilder prefix = new StringBuilder();
      for(String word : partial) {
         prefix.append(word.charAt(row));
      }

      for(String word : getWordsWithPrefix(prefix.toString())) {

         partial.add(word);
         backtrack(row + 1, partial);
         partial.remove(partial.size() - 1);

      }
   }


   public List<List<String>> wordSquares(String[] words) {
      dimension = words[0].length();
      this.words = words;
      result = new ArrayList<>();

      buildPrefixHashTable();

      for(String word : words) {
         List<String> partial = new ArrayList<>();
         partial.add(word);
         backtrack(1, partial);
      }

      return result;
   }
}
