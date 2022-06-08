public class Solution {
    /**
     * @param airplanes: an array of meeting time airplanes
     * @return: the minimum number of conference rooms required
     */
    
     public int countOfAirplanes(List<Interval> airplanes) {
        if(airplanes == null || airplanes.size() == 0) return 0;
        List<int[]> list = new ArrayList<>(airplanes.size() * 2);
        for(int i = 0; i < airplanes.size(); i++) {
            list.add(new int[]{airplanes.get(i).start, 1});
            list.add(new int[]{airplanes.get(i).end, -1});
        }
        list.sort((p1,p2) -> {
            return (p1[0] != p2[0]) ? Integer.compare(p1[0] , p2[0]) : Integer.compare(p1[1] , p2[1]);
        });

        int ans = 0;
        int cnt = 0;
        for(int i = 0; i < list.size(); i++) {
            cnt += list.get(i)[1];
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
