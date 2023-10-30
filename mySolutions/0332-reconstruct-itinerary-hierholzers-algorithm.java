import java.util.*;

class Solution {

    private void backtrack(String source, List<String> itinerary, Map<String, Queue<String>> map) {
        Queue<String> destinations = map.get(source);
        while (destinations != null && !destinations.isEmpty()) {
            String destination = destinations.poll();
            backtrack(destination, itinerary, map);
        }
        itinerary.add(0, source);
    }

    public List<String> findItinerary(List<List<String>> tickets) {

        // build adjacency list, remove one flight once visited
        Map<String, Queue<String>> map = new HashMap<>();
        int flights = tickets.size();
        for(List<String> list : tickets) {
            String departure = list.get(0);
            Queue<String> destinations = map.getOrDefault(departure, new PriorityQueue<String>());
            destinations.add(list.get(1));
            map.put(departure, destinations);
        }

        // initiate itinerary to store the answer
        List<String> itinerary = new ArrayList<>();
        backtrack("JFK", itinerary, map);

        return itinerary;
    }
}
