import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");

        if(pattern.length() != arr.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        for(int i = 0; i < pattern.length(); i ++) {
            if(!map.containsKey(pattern.charAt(i))) {
                map.put(pattern.charAt(i), arr[i]);
            } else {
                if(!map.get(pattern.charAt(i)).equals(arr[i])) {
                    return false;
                }
            }
        }

        Map<String, Character> mapReverse = new HashMap<>();

        for(int i = 0; i < arr.length; i ++) {
            if(!mapReverse.containsKey(arr[i])) {
                mapReverse.put(arr[i], pattern.charAt(i));
            } else {
                if(!mapReverse.get(arr[i]).equals(pattern.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }
}