class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null) return false;
        int count = rooms.size();
        HashSet<Integer> visited = new HashSet();
        visited.add(0);
        
        Queue<Integer> queue = new LinkedList();
        for(Integer key : rooms.get(0)){
            queue.add(key);
        }
        
        while(queue.size()>0){
            Integer key = queue.poll();
            if(visited.contains(key)) continue;
            visited.add(key);
            
            for(Integer newKey : rooms.get(key)){
                queue.add(newKey);
            }
        }
        
        return visited.size() == rooms.size();
    }
}