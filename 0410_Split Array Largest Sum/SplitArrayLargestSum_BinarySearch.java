class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for(int v : nums) {
            max = Math.max(max, v);
            sum += v;
        }
        
        // l -> split each element,  r -> no split
        int l = max, r = sum;
        while(l < r) {
            int mid = (r-l)/2 + l; // find a mid value is the sum of subArrays
            int numOfSubarrays = split(nums, mid);
            if(numOfSubarrays > m)
                l = mid + 1;
            else
                r = mid;
        }
        
        return l;
    }
    
    // return the count of subArrays and the sum of each subArray is <= validMaxSum;
    // the default value of pieces should be 1 since at least it has 1 subArray which is itself. 
    private int split(int[] nums, int validMaxSum) {
        int pieces = 1;
        int tmpSum = 0;
        for(int v : nums) {
            if(tmpSum + v > validMaxSum) {
                tmpSum = v;
                pieces++;
            }else{
                tmpSum += v;
            }
        }
        
        return pieces;
    }
}