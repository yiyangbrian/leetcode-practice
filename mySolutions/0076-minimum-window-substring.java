import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Character, Integer> toMap(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i ++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        return hm;
    }

    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int[] position = {-1, 0, 0};

        //complete indicates if the substring is desirable,
        //containing all the characters in t.
        int complete = 0;

        Map<Character, Integer> dict = toMap(t);

        System.out.println(dict);

        Map<Character, Integer> dynamic = new HashMap<>();

        while(right < n) {

            char c = s.charAt(right);

            if(dict.containsKey(c)) {
                dynamic.put(c, dynamic.getOrDefault(c, 0) + 1);
                if(dict.get(c).intValue() == dynamic.get(c).intValue()) {
                    complete ++;
                }
            }

            while(left <= right && complete == dict.size()) {

                if(position[0] == -1 || right + 1 - left < position[2] - position[1]) {
                    position[0] = right - left + 1;
                    position[1] = left;
                    position[2] = right + 1;
                }

                char contract = s.charAt(left);

                if(dynamic.containsKey(contract)) {
                    dynamic.put(contract, dynamic.get(contract) - 1);
                    if(dynamic.get(contract).intValue() < dict.get(contract).intValue()) {
                        complete --;
                    }
                }

                left ++;
            }

            right ++;
        }
        return s.substring(position[1], position[2]);
    }
}