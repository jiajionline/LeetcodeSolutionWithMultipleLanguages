class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        if(words == null || words.length == 0) return 0;
        int ans = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) map.put(c, new ArrayList<Integer>());
            map.get(c).add(i);
        }
        
        for(String t : words) {
            if(isSubsequence(s.length(), t, map)) ans++;
        }
        
        return ans;
    }
    
    
    // check if t is a subsequence of s
    private boolean isSubsequence(int maxLen, String t, Map<Character, List<Integer>> map) {
        if(t.isEmpty()) return true;
        int prev = -1;
        for(Character c : t.toCharArray()) {
            if(!map.containsKey(c)) return false;
            List<Integer> list = map.get(c);
            int l = 0, r = list.size();
            while(l < r) {
                int mid = (r-l)/2 + l;
                if(list.get(mid) > prev) {
                    r = mid;
                }else {
                    l = mid + 1;
                }
            }
            
            if(l >= list.size()) return false;
            prev = list.get(l);
        }
        
        return true;
    }
}