class Solution {
    public int minOperations(int[] nums) {
        int countOf1 = 0;
        int maxShift = 0;
        
        for(int v : nums) {
            // h to check the highest 1
            int h = 0;
            while(v!=0) {
                if((v & 1) == 1) {
                    countOf1++;
                } 
                h++;
                v >>= 1;
            }

            // the count of shift left ( X2 operation), need to minus 1 since the first 1 not needed to X2
            h--;
            
            maxShift = Math.max(maxShift, h);
        }
        
        return countOf1 + maxShift;
    }
}