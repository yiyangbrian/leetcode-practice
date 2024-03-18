import java.util.*;

class Solution {
    public String alienOrder(String[] words) {
        Set<Character> pool = new HashSet<>();

        for(String word : words) {
            for(int i = 0; i < word.length(); i ++) {
                pool.add(word.charAt(i));
            }
        }

        int n = words.length;
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for(int i = 1; i < n; i ++) {
            String a = words[i - 1];
            String b = words[i];
            int length = Math.min(a.length(), b.length());
            boolean found = false;
            for(int j = 0; j < length; j ++) {
                if(a.charAt(j) != b.charAt(j)) {

                    char lower = a.charAt(j);
                    char higher = b.charAt(j);

                    // check if illegal
                    if(map.containsKey(higher) && map.get(higher).contains(lower)) {
                        return "";
                    }

                    if(!map.containsKey(lower) || !map.get(lower).contains(higher)) {
                        map.computeIfAbsent(lower, val -> new HashSet<>()).add(higher);
                        indegree.put(lower, indegree.getOrDefault(lower, 0));
                        indegree.put(higher, indegree.getOrDefault(higher, 0) + 1);
                    }

                    found = true;
                    break;
                }
            }
            if(!found && b.length() < a.length()) {
                return "";
            }
        }

        String res = "";

        Deque<Character> queue = new ArrayDeque<>();

        for(char ch : map.keySet()) {
            if(indegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i ++) {
                char cur = queue.poll();

                if(map.get(cur) != null) {
                    for(char neighbor : map.get(cur)) {
                        int in = indegree.get(neighbor);
                        indegree.put(neighbor, in - 1);
                        if(indegree.get(neighbor) == 0) {
                            queue.offer(neighbor);
                        }
                    }
                }

                map.remove(cur);
                res += cur;
                pool.remove(cur);
            }
        }

        if(!map.isEmpty()) {
            return "";
        }

        for(char left : pool) {
            res += left;
        }

        return res;
    }
}
