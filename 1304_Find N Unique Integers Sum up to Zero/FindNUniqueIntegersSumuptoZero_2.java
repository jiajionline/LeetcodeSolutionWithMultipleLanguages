class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int index = n % 2 == 1 ? 1 : 0;
        int v = 1;
        for(int i = index;i<n;i+=2){
            ans[i] = v;
            ans[i+1] = -v;
            v++; 
        }
        return ans;
    }
}