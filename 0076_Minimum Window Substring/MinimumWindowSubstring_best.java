class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        int[] map = new int[128];
        for (int i = 0; i < n; i++) map[t.charAt(i)]++;
        
        int count = 0, i = 0, j = 0, minLen = Integer.MAX_VALUE, start = -1;
        while (j < m) {
            if (map[s.charAt(j++)]-- > 0) count++;
            while (count == n) {
                if (j-i < minLen) {
                    minLen = j-i;
                    start = i;
                }
                if (++map[s.charAt(i++)] > 0) count--;
            }
        }
        return start == -1 ? "" : s.substring(start, start + minLen);
        
        
    }
}