class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for(int[] update : updates) {
            int start = update[0];
            int end = update[1] + 1;
            int value = update[2];
            if(start >= 0 && start < length) {
                ans[start] += value;
            }
            
            if(end >= 0 && end < length) {
                ans[end] -= value;
            }
        }
        
        int sum = 0;
        for(int i=0;i<ans.length;i++) {
            sum += ans[i];
            ans[i] = sum;
        }
        
        return ans;
    }
}