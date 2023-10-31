import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> smap = new HashMap<>();
        for(int i = 0; i < s.length(); i ++) {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < t.length(); i ++) {
            if(!smap.containsKey(t.charAt(i))) {
                return false;
            } else {
                smap.put(t.charAt(i), smap.get(t.charAt(i)) - 1);
            }
        }

        for(Map.Entry<Character, Integer> entry : smap.entrySet()) {
            if(entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }
}
