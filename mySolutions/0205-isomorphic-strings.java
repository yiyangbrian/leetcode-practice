import java.util.HashMap;
import java.util.Map;

class Solution {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for(int i = 0; i < s.length(); i ++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            }

            if(map.containsKey(s.charAt(i))
                    && map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }

        map.clear();

        for(int i = 0; i < t.length(); i ++) {
            if(!map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), s.charAt(i));
            }

            if(map.containsKey(t.charAt(i))
                    && map.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
        }



        return true;

    }
}
