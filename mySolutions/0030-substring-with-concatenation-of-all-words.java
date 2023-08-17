import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private Map<String, Integer> wordsMap(String[] words) {
        Map<String, Integer> hm = new HashMap<>();
        for(String word : words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }
        return hm;
    }

    public List<Integer> findSubstring(String s, String[] words) {

        int lenStr = s.length();
        int lenWord = words[0].length();
        int lenSec = lenWord * words.length;
        List<Integer> ans = new ArrayList<>();

        if(lenStr < lenSec || lenStr == 0 || words.length == 0) {
            return ans;
        }

        Map<String, Integer> hm = wordsMap(words);

        for(int i = 0; i <= lenStr - lenSec; i ++) {

            Map<String, Integer> tempHm = new HashMap(hm);
            for(int k = i; k <= i + lenSec - lenWord; k += lenWord) {
                String currentWord = s.substring(k, k + lenWord);
                if(!tempHm.containsKey(currentWord)) {
                    break;
                } else if(tempHm.get(currentWord) == 1) {
                    tempHm.remove(currentWord);
                } else {
                    tempHm.put(currentWord, tempHm.get(currentWord) - 1);
                }
            }
            if(tempHm.isEmpty()){
                ans.add(i);
            }

        }

        return ans;
    }
}
