class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        
        for(int[] update : updates) {
            int start = update[0];
            int end = update[1] + 1;
            int v = update[2];
            
            if(start >= 0 && start < length) ans[start] += v;
            if(end >= 0 && end < length) ans[end] -= v;
        }
        
        int accumalate = 0;
        for(int i=0;i<ans.length;i++) {
            accumalate += ans[i];
            ans[i] = accumalate;
        }
        
        return ans;
    }
}