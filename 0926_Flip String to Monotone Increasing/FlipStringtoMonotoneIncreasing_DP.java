class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] dpZero = new int[n+1];
        int[] dpOne = new int[n+1];
        
        for(int i=1;i<=n;i++) {
            // handle 0
            if(s.charAt(i-1) == '0') {
                // from '0' to '0' , no need to transition
                dpZero[i] = dpZero[i-1];
                // from  '0' to '1' 
                dpOne[i] = Math.min(dpZero[i-1], dpOne[i-1]) + 1;
            }else {
                // from '1' to '0'
                dpZero[i] = dpZero[i-1] + 1;
                // from '1' to '1'
                dpOne[i] = Math.min(dpOne[i-1], dpZero[i-1]);
            }
        }
        
        return Math.min(dpZero[n], dpOne[n]);
    }
}