class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[1] - b[1]);
        boolean[] seen = new boolean[100001];
        int ans = 0;
        for(int[] event : events) {
            for(int day = event[0];day<=event[1];day++) {
                if(!seen[day]) {
                    seen[day] = true;
                    ans++;
                    break;
                }
            }
        }
        
        return ans;
    }
}