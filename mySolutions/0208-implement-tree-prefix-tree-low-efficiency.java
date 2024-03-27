class Trie {

   private Trie[] array;
   private boolean end;

   public Trie() {
      array = new Trie[26];
      end = false;
   }

   public void set(int loc) {
      array[loc] = new Trie();
   }

   public Trie get(int loc) {
      return array[loc];
   }

   public boolean isEnd() {
      return end;
   }

   public void setEnd() {
      end = true;
   }

   public void insert(String word) {
      Trie p = this;
      for(int i = 0; i < word.length(); i ++) {
         if(p.get(word.charAt(i) - 'a') == null ) {
            p.set(word.charAt(i) - 'a');
         }
         p = p.get(word.charAt(i) - 'a');
      }
      p.setEnd();
   }

   public boolean search(String word) {
      Trie p = this;
      for(int i = 0; i < word.length(); i ++) {
         if(p.get(word.charAt(i) - 'a') == null) return false;
         p = p.get(word.charAt(i) - 'a');
      }
      if(p.isEnd()) {
         return true;
      } else {
         return false;
      }
   }

   public boolean startsWith(String prefix) {
      Trie p = this;
      for(int i = 0; i < prefix.length(); i ++) {
         if(p.get(prefix.charAt(i) - 'a') == null) return false;
         p = p.get(prefix.charAt(i) - 'a');
      }
      return true;
   }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
