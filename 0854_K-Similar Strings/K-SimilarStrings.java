class Solution {
    public int kSimilarity(String s1, String s2) {
        if(s1.equals(s2)) return 0;
        int ans = 0;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(s1);
        visited.add(s1);
        
        
        while(queue.size() > 0) {
            int size = queue.size();
            
            while(size-- > 0) {
                String s = queue.poll();
                if(s.equals(s2)) return ans;
                
                char[] chars = s.toCharArray();
                int i = 0;
                while(i < chars.length && chars[i] == s2.charAt(i)) {
                    i++;
                }
                
                int j = i+1;
                while(j < chars.length) {
                    if(chars[j] == s2.charAt(i)) {
                        swap(chars, i, j);
                        String newS = new String(chars);
                        if(visited.add(newS))
                            queue.add(newS);
                        swap(chars, i, j);
                    }
                    j++;
                }
            }
            
            ans++;
        }
        
        return -1;
    }
    
    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}