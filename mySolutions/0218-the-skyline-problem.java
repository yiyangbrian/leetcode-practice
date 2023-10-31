import java.util.*;

class Solution {

    public List<List<Integer>> getSkyline(int[][] buildings) {

        Map<Integer, List<Integer>> mapIn = new HashMap<>(); // left x : index of buildings
        Map<Integer, List<Integer>> mapOut = new HashMap<>(); // right x : index of buildings

        // create int[] for every coordinate we should process
        // i.e. every left x and right x of each building
        // sort the int[], then iterate each x

        Set<Integer> coordinatesSet = new HashSet<>();

        for(int i = 0; i < buildings.length; i ++) {
            coordinatesSet.add(buildings[i][0]);
            coordinatesSet.add(buildings[i][1]);
            List<Integer> listIn = mapIn.getOrDefault(buildings[i][0], new ArrayList<Integer>());
            listIn.add(i);
            mapIn.put(buildings[i][0], listIn);
            List<Integer> listOut = mapOut.getOrDefault(buildings[i][1], new ArrayList<Integer>());
            listOut.add(i);
            mapOut.put(buildings[i][1], listOut);
        }

        int[] coordinates = new int[coordinatesSet.size()];
        int index = 0;
        for(int x : coordinatesSet) {
            coordinates[index] = x;
            index ++;
        }
        Arrays.sort(coordinates);

        // building indexes in PQ are sorted by their heights

        Queue<Integer> height = new PriorityQueue<>((a, b) -> buildings[b][2] - buildings[a][2]);

        List<List<Integer>> skyline = new ArrayList<>();

        for(int x : coordinates) {

            // add buildings to PQ if buildings[i][0] == x
            // when building[i]'s height is larger than the largest in the PQ,
            // or no buildings are in PQ, create a new skyline

            List<Integer> newBuildings = mapIn.get(x);

            int tempMaxHeight = 0;
            if(newBuildings != null) {
                for(int i : newBuildings) {
                    if(height.isEmpty() || buildings[i][2] > buildings[height.peek()][2]) {
                        tempMaxHeight = buildings[i][2];
                    }
                    height.offer(i);
                }
                if(tempMaxHeight != 0) {
                    List<Integer> newLine = new ArrayList<>();
                    newLine.add(x);
                    newLine.add(tempMaxHeight);
                    skyline.add(newLine);
                }
            }

            // remove buildings from PQ if buildings[i][1] == x
            // by removing building[i], if PQ will be empty, or
            // building[i]'s height is the largest in the PQ (the secondHeight should < currHeight)
            // then create a new skyline

            List<Integer> oldBuildings = mapOut.get(x);

            int secondHeight = 0;
            int currHeight = 0;
            if(oldBuildings != null) {
                for(int i : oldBuildings) {
                    currHeight = buildings[i][2];
                    if(buildings[height.peek()][2] == currHeight) {
                        height.remove(i);
                        secondHeight = height.size() > 0 ? buildings[height.peek()][2] : 0;
                    } else {
                        height.remove(i);
                    }
                }
                List<Integer> removeBuildings = new ArrayList<>();
                if(height.size() == 0) {
                    removeBuildings.add(x);
                    removeBuildings.add(0);
                    skyline.add(removeBuildings);
                } else if(secondHeight != 0 && secondHeight != currHeight) {
                    removeBuildings.add(x);
                    removeBuildings.add(secondHeight);
                    skyline.add(removeBuildings);
                }
            }
        }

        return skyline;
    }
}
