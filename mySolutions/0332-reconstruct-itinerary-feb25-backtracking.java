class Solution {
   List<String> result;
   int numTickets;
   Map<String, Map<String, Integer>> map;

   private boolean backtrack(List<String> cur) {
      if(cur.size() == numTickets + 1) {
         result = new LinkedList<>(cur);
         return true;
      }
      String departure = cur.get(cur.size() - 1);
      Map<String, Integer> destinations = map.get(departure);

      if(destinations != null) {
         for(String destination : destinations.keySet()) {
            int flights = destinations.get(destination);
            if(flights > 0) {
               cur.add(destination);
               destinations.put(destination, flights - 1);
               if(backtrack(cur)) {
                  return true;
               }
               cur.removeLast();
               destinations.put(destination, flights);
            }
         }
      }
      return false;

   }

   public List<String> findItinerary(List<List<String>> tickets) {
      this.numTickets = tickets.size();

      Map<String, Map<String, Integer>> map = new HashMap<>();
      for(List<String> ticket : tickets) {
         String departure = ticket.get(0);
         String destination = ticket.get(1);
         Map<String, Integer> destinations = map.getOrDefault(departure, new TreeMap<>());

         int flightNum = destinations.getOrDefault(destination, 0);
         destinations.put(destination, flightNum + 1);
         map.put(departure, destinations);
      }

      this.map = map;
      List<String> cur = new LinkedList<>();
      cur.add("JFK");

      backtrack(cur);

      return result;
   }
}
