class Solution {
    public int singleNumber(int[] nums) {
        int[] bitCount = new int[32];
        for(int v : nums) {
            for(int i=0;i<32;i++) {
                if(((1 << i) & v) != 0) 
                    bitCount[i]++;
            }
        }
        
        int ans = 0;
        for(int i=0;i<bitCount.length;i++) {
            bitCount[i] %= 3;
            if(bitCount[i] > 0) {
                ans |= (1 << i); 
            }
        }
        
        return ans;
    }
}