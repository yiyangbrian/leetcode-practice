import java.util.*;

class Solution {
    Map<String, Map<String, Integer>> map;
    LinkedList<String> ans;
    int n;

    public List<String> findItinerary(List<List<String>> tickets) {

        n = tickets.size();
        map = new HashMap<>();
        ans = new LinkedList<>();

        for(List<String> ticket : tickets) {
            String departure = ticket.get(0);
            String destination = ticket.get(1);
            map.put(departure, map.getOrDefault(departure, new TreeMap<String, Integer>()));
            Map<String, Integer> destinations = map.get(departure);
            destinations.put(destination, destinations.getOrDefault(destination, 0) + 1);
        }

        ans.add("JFK");
        backtrack();
        return ans;
    }

    private boolean backtrack() {
        if(ans.size() == n + 1) {
            return true;
        }

        String last = ans.getLast();

        if(map.containsKey(last)) {
            for(Map.Entry<String, Integer> destination : map.get(last).entrySet()) {
                int itineraries = destination.getValue();
                if(itineraries > 0) {
                    ans.add(destination.getKey());
                    destination.setValue(itineraries - 1);
                    if(backtrack()) {
                        return true;
                    }
                    destination.setValue(itineraries);
                    ans.removeLast();
                }
            }
        }
        return false;
    }
}
