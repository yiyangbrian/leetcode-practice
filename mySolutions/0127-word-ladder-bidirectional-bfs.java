import java.util.*;

class Solution {

    private int L = 0;
    private Map<String, List<String>> allComboDict = new HashMap<>();

    private int visitWordNode(Queue<Pair<String, Integer>> Q, Map<String, Integer> visited, Map<String, Integer> othersVisited) {

        for(int j = Q.size(); j > 0; j --) {

            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();

            for(int i = 0; i < L; i ++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                for(String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    if(othersVisited.containsKey(adjacentWord)) {
                        return level + othersVisited.get(adjacentWord);
                    }

                    if(!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, level + 1);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }

                }
            }
        }
        return -1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)) {
            return 0;
        }

        L = beginWord.length();

        wordList.forEach( word -> {
            for(int i = 0; i < L; i ++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        });

        Queue<Pair<String, Integer>> Q_begin = new LinkedList<>();
        Queue<Pair<String, Integer>> Q_end = new LinkedList<>();

        Q_begin.add(new Pair(beginWord, 1));
        Q_end.add(new Pair(endWord, 1));

        Map<String, Integer> visitedBegin = new HashMap<>();
        Map<String, Integer> visitedEnd = new HashMap<>();
        visitedBegin.put(beginWord, 1);
        visitedEnd.put(endWord, 1);
        int ans = -1;

        while(!Q_begin.isEmpty() && !Q_end.isEmpty()) {
            if(Q_begin.size() <= Q_end.size()) {
                ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
            } else {
                ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
            }

            if(ans > -1) {
                return ans;
            }
        }
        return 0;
    }
}
