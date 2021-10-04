class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            if (count > (S.length() + 1) / 2) return "";
            map.put(c, count);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c : map.keySet()) {
            pq.add(new int[] {c, map.get(c)});
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(pq.size() >= 2)
        {
            int[] first = pq.poll();
            int[] second = pq.poll();
            sb.append((char)first[0]);
            sb.append((char)second[0]);
            
            first[1]--;
            second[1]--;
            if(first[1] > 0) pq.add(first);
            if(second[1] > 0) pq.add(second);
        }
        
        if(pq.size() > 0){
            sb.append((char)(pq.poll()[0]));
        }
        
        
        return sb.toString();
    }
}