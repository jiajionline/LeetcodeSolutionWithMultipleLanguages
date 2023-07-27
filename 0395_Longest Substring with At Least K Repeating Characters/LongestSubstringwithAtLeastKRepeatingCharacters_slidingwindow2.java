class Solution {
    public int longestSubstring(String s, int k) {
        int ans = 0;
        int maxUnique = maxUnique(s);
        Map<Character, Integer> map = new HashMap<>();
        for(int unique = 1; unique <= maxUnique; unique++) {
            map.clear();
            int l = 0, validCount = 0;
            for(int r=0;r<s.length();r++) {
                char c = s.charAt(r);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if(map.get(c) == k) validCount++;
                while(map.size() > unique) {
                    char lChar = s.charAt(l);
                    int lCharCount = map.get(lChar);
                    if(lCharCount == k) validCount--;
                    if(lCharCount == 1)
                        map.remove(lChar);
                    else
                        map.put(lChar, lCharCount-1);
                    l++;
                }
                int count = map.size();
                if(count == unique && count == validCount) ans = Math.max(ans, r - l + 1);
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