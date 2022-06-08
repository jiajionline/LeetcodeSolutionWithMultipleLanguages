public class Solution {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        if(airplanes == null || airplanes.size() == 0) return 0;
        airplanes.sort((a,b) -> a.start-b.start);
        Queue<Interval> pq = new PriorityQueue<Interval>((a,b) -> a.end-b.end);
        int ans = 0;
        for (Interval airplane : airplanes) {
            if (!pq.isEmpty() && pq.peek().end <= airplane.start) pq.poll();
            pq.offer(airplane);
            ans = Math.max(ans, pq.size());
        }
        return ans;
    }
}