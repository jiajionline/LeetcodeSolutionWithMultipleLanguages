class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        DFS(rooms, 0, visited);
        
        for(boolean v : visited)
            if(!v) return false;
        
        return true;
    }

    private void DFS(List<List<Integer>> rooms, int room, boolean[] visited) {
        List<Integer> keys = rooms.get(room);
        for(int key : keys) {
            if(visited[key]) continue;
            visited[key] = true;
            DFS(rooms, key, visited);
        }
    }
}