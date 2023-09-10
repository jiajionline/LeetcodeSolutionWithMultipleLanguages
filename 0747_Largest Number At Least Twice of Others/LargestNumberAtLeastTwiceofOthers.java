class Solution {
    public int dominantIndex(int[] nums) {
        int index = -1;
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int v = nums[i];
            if(v > max){
                secondMax = max;
                max = v;
                index = i;
            }else if(v > secondMax) {
                secondMax = v;
            }
        }

        return max >= secondMax * 2 ? index : -1;
    }
}