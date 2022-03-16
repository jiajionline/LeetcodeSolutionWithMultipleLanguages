class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int ans = 0;
        int l = 0;
        Map<Character, Integer> map = new HashMap();
        
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
            
            while(map.size() > 2) {
                char leftC = s.charAt(l++);
                if(map.containsKey(leftC)) {
                    map.put(leftC, map.get(leftC) - 1);
                    if(map.get(leftC) == 0)
                        map.remove(leftC);
                }
            }
            
            if(map.size() <= 2) {
                ans = Math.max(ans, r - l + 1);
            }
        }
        
        return ans;
    }
}