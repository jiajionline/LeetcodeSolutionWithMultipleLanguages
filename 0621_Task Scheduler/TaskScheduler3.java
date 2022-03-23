class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap();
        for(char c : tasks)
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        Queue<Integer> queue = new PriorityQueue<Integer>((a,b) -> b - a);
        queue.addAll(map.values());
        int cycle = n + 1;
        int ans = 0;
        
        while(queue.size() > 0) {
            int worktime = 0;
            List<Integer> list = new ArrayList();
            while(worktime < cycle) {
                if(queue.size() > 0) {
                    int v = queue.poll();
                    worktime++;
                    if(v > 1) list.add(v-1);    
                } else {
                    if(list.size() > 0) {
                        worktime++;
                    }else{
                        break;
                    }
                }
            }
            
            ans += worktime;
            for(int i=0;i<list.size();i++)
                queue.add(list.get(i));
        }
        
        return ans;
        
    }
}
