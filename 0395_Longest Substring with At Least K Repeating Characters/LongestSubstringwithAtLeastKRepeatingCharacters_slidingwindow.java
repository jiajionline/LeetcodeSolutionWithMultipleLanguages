class Solution {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() < k) return 0;
        int[] counters = new int[26];
        int maxUnique =  maxUnique(s);
        int ans = 0;
        
        for(int currUnique = 1; currUnique<=maxUnique; currUnique++) {
            Arrays.fill(counters, 0);
            int start = 0;
            int end = 0;
            int idx = 0;
            int unique = 0;
            int countAtLeastK = 0;
            
            while(end < s.length()) {
                //expend the window
                if(unique <= currUnique)
                {
                    idx = s.charAt(end) - 'a';
                    if(counters[idx] == 0) unique++;
                    counters[idx]++;
                    if(counters[idx] == k) countAtLeastK++;
                    end++;
                }
                else
                {
                    //shrink the window
                    idx = s.charAt(start) - 'a';
                    if(counters[idx] == k) countAtLeastK--;
                    counters[idx]--;
                    if(counters[idx] == 0) unique--;
                    start++;
                }
                
                if(unique == currUnique && unique == countAtLeastK){
                    ans = Math.max(ans, end - start);
                }
            }
        }
        
        return ans;
    }
    
    private int maxUnique(String s) {
        boolean[] check = new boolean[26];
        int ans = 0;
        for(char c : s.toCharArray()) {
            if(!check[c-'a'])
            {
                ans++;
                check[c-'a'] = true;
            }
        }
        
        return ans;
    }
}