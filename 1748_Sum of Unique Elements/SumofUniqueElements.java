class Solution {
    public int sumOfUnique(int[] nums) {
        int[] count = new int[101];
        for(int v : nums) count[v]++;
        int ans = 0;
        for(int i=1;i<count.length;i++) {
            if(count[i] == 1) ans += i;
        }
        
        return ans;
    }
}