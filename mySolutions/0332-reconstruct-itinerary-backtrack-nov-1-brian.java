import java.util.*;

class Solution {
    Map<String, Map<String, Integer>> map;
    List<String> ans;
    int totalTickets; // total number of tickets.

    private boolean backtrack(String departure, List<String> itinerary) {
        if(itinerary.size() == totalTickets + 1) {
            ans = new LinkedList<String>(itinerary);
            return true;
        }

        Map<String, Integer> destinations = map.get(departure);
        if(destinations != null) {
            for(Map.Entry<String, Integer> entry : destinations.entrySet()) {
                String destination = entry.getKey();
                int flights = entry.getValue();
                if(flights > 0) {
                    itinerary.add(destination);
                    destinations.put(destination, flights - 1);
                    if(backtrack(destination, itinerary)) {
                        return true;
                    }
                    itinerary.remove(itinerary.size() - 1);
                    destinations.put(destination, flights);
                }
            }
        }
        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        this.totalTickets = tickets.size();

        // build adjacency list

        map = new HashMap<>();
        for(List<String> ticket : tickets) {
            String departure = ticket.get(0);
            String arrival = ticket.get(1);

            map.put(departure, map.getOrDefault(departure, new TreeMap<>()));
            Map<String, Integer> arrivals = map.get(departure);
            arrivals.put(arrival, arrivals.getOrDefault(arrival, 0) + 1);
        }

        // initiate List to store the answer

        List<String> itinerary = new LinkedList<>();
        itinerary.add("JFK");

        backtrack("JFK", itinerary);

        return ans;
    }
}