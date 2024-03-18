import java.util.HashSet;
import java.util.Set;

class Solution {
   public int numUniqueEmails(String[] emails) {
      Set<String> set = new HashSet<>();


      for(String email : emails) {

         StringBuilder localName = new StringBuilder();

         for(int i = 0; i < email.length(); i ++) {
            char ch = email.charAt(i);
            if(ch == '+' || ch == '@') break;
            if(ch == '.') continue;
            localName.append(ch);
         }

         StringBuilder domainName = new StringBuilder();

         for(int i = email.length() - 1; i >= 0; i --) {
            char ch = email.charAt(i);
            domainName.insert(0, ch);
            if(ch == '@') break;
         }

         localName.append(domainName);
         set.add(localName.toString());
      }

      return set.size();
   }
}
