class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,List<String>> map = new HashMap();
        for(List<String> ticket : tickets) {
            String departure = ticket.get(0);
            String arrival = ticket.get(1);
            if(!map.containsKey(departure)) map.put(departure, new ArrayList<String>());
            map.get(departure).add(arrival);
        }
        
        for(List<String> list : map.values())
            Collections.sort(list);
        
        List<String> ans = new ArrayList<String>();
        visit(map, "JFK", ans);
        Collections.reverse(ans);
        return ans;
    }
    
    private void visit(HashMap<String, List<String>> map, String departure, List<String> ans) {
        if(map.containsKey(departure)) {
            List<String> list = map.get(departure);
            while(list.size() > 0) {
                String arrival = list.get(0);
                list.remove(0);
                visit(map, arrival, ans);
            }
        }
        
        ans.add(departure);
    }
}