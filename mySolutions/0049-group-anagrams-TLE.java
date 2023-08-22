import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private boolean isAnagrams(String s, String t) {
        Map<Character, Integer> smap = new HashMap<>();

        for(int i = 0; i < s.length(); i ++) {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < t.length(); i++) {
            if(!smap.containsKey(t.charAt(i))) {
                return false;
            } else {
                smap.put(t.charAt(i), smap.get(t.charAt(i)) - 1);
            }
        }

        for(char ch : smap.keySet()) {
            if(smap.get(ch) != 0) {
                return false;
            }
        }

        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> outer = new ArrayList<>();

        for(String str : strs) {
            boolean found = false;
            for(List<String> inner : outer) {
                if(isAnagrams(inner.get(0), str)) {
                    inner.add(str);
                    found = true;
                    break;
                }
            }
            if(!found) {
                List<String> newInner = new ArrayList<>();
                newInner.add(str);
                outer.add(newInner);

            }

        }


        return outer;
    }
}