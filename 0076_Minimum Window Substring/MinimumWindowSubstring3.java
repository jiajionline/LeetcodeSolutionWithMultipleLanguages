class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if(m < n) return "";
        
        int l = 0, start = -1, len = Integer.MAX_VALUE;
        int[] arr = new int[128];
        for(char c : t.toCharArray()) {
            arr[c]+=1;
        }
        
        for(int i=0;i<m;i++) {
            arr[s.charAt(i)]--;
            if(check(arr)){
                while(check(arr)) {
                    if(i-l+1 < len) {
                        len = i-l+1;
                        start = l;
                    }
                    arr[s.charAt(l++)]++;
                }
            }
        }
        
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
    
    private boolean check(int[] arr) {
        for(int v : arr){
            if(v > 0) return false;
        }
        
        return true;
    }
}