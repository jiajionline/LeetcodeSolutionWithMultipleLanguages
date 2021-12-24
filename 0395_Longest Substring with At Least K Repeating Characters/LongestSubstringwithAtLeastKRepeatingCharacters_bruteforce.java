class Solution {
    public int longestSubstring(String s, int k) {
        if(s== null || s.length() < k) return 0;
        
        int[] arr = new int[26];
        int ans = 0;
        
        for(int start = 0;start < s.length();start++) {
            Arrays.fill(arr,0);
            for(int end = start;end < s.length(); end++) {
                arr[s.charAt(end)-'a']++;
                if(isValid(arr,k)) {
                    ans = Math.max(ans, end - start + 1);
                }
            }
        }
        return ans;
    }
    
    private boolean isValid(int[] arr, int k) {
        int letterCount = 0;
        int letterAtLeastK = 0;
        
        for(int v : arr) {
            if(v > 0) letterCount++;
            if(v >= k) letterAtLeastK++;
        }
        
        return letterCount > 0 && letterCount == letterAtLeastK;
    } 
}