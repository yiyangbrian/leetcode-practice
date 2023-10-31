import java.util.*;

class Solution {
    private int charDifference(String currWord, String targetWord) {
        int count = 0;
        for(int i = 0; i < currWord.length(); i ++) {
            if(currWord.charAt(i) != targetWord.charAt(i)) {
                count ++;
            }
        }
        return count;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int sequenceNum = 0;

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        Set<String> wordSeen = new HashSet<>();

        while(!queue.isEmpty()) {

            int size = queue.size();

            for(int j = 0; j < size; j ++) {
                String currWord = queue.poll();
                for(int i = 0; i < wordList.size(); i ++) {
                    String targetWord = wordList.get(i);
                    if(targetWord != null && charDifference(currWord, targetWord) == 1) {
                        queue.add(targetWord);
                        wordList.set(i, null);
                        wordSeen.add(targetWord);
                    }
                }
            }

            sequenceNum ++;

            if(wordSeen.contains(endWord)) {
                return sequenceNum + 1;
            }
        }

        return 0;
    }
}
