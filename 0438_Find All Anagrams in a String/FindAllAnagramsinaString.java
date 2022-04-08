class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] arr = new int[26];
        for(int i=0;i<p.length();i++) {
            arr[p.charAt(i) - 'a']++;
        }
        
        for(int i=0;i<s.length();i++) {
    
            arr[s.charAt(i) - 'a']--;
            if(i - p.length() >= 0) {
                arr[s.charAt(i-p.length()) - 'a']++;
            }
            
            if(allZeros(arr)) {
                ans.add(i - p.length()+1);
            }
        }
        
        return ans;
    }
    
    private boolean allZeros(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i] != 0) return false;
        }
        
        return true;
    }
}