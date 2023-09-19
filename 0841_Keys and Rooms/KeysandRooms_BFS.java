class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        
        while(queue.size() > 0) {
            int room = queue.poll();
            
            for(Integer key : rooms.get(room)) {
                if(visited[key]) continue;
                queue.add(key);
                visited[key] = true;
            }
        }
        
        for(boolean v : visited)
            if(!v) return false;
        
        return true;
    }
}