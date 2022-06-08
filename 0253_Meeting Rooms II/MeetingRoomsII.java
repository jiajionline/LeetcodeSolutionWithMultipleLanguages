class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null) return 0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int[] interval : intervals) {
            if(pq.size() > 0 && interval[0] >= pq.peek()) pq.poll();
            pq.add(interval[1]);
        }
        
        return pq.size();
    }
}

// another similar solution

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null) return 0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int ans = 0;
        for(int[] interval : intervals) {
            while(pq.size() > 0 && interval[0] >= pq.peek()) pq.poll();
            pq.add(interval[1]);
            ans = Math.max(ans, pq.size());
        }
        
        return ans;
    }
}