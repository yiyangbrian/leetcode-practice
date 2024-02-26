/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
   public void findSecretWord(String[] words, Master master) {

      Random random = new Random();

      int i = 0;
      int matches = 0;
      List<String> candidates = new LinkedList<>();
      for(String word : words) {
         candidates.add(word);
      }

      while(matches != 6) {

         int randomPos = random.nextInt(candidates.size());

         String cur = candidates.get(randomPos);
         matches = master.guess(cur);
         i ++;
         List<String> tempCandidates = new LinkedList<>();

         if(matches != 6) {
            for(int j = 0; j < candidates.size(); j ++) {
               String candidate = candidates.get(j);
               if(!candidate.equals(cur) && selected(cur, candidate, matches)) {
                  tempCandidates.add(candidate);
               }
            }
         }

         candidates = tempCandidates;
      }

      System.out.println(i);


   }

   private boolean selected(String cur, String candidate, int matches) {
      int chars = 0;
      for(int i = 0; i < 6; i ++) {
         if(cur.charAt(i) == candidate.charAt(i)) {
            chars ++;
         }
      }
      return chars == matches;
   }
}
