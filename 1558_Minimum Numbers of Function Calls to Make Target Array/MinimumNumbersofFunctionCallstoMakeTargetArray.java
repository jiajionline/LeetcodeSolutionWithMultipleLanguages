class Solution {
    public int minOperations(int[] nums) {
        int countOf1 = 0;
        int highest = 0;
        
        for(int v : nums) {
            int h = -1;
            while(v!=0) {
                if((v & 1) == 1) {
                    countOf1++;
                } 
                h++;
                v >>= 1;
            }
            
            highest = Math.max(highest, h);
        }
        
        return countOf1 + highest;
    }
}