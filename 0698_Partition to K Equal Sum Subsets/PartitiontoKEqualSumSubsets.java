class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums == null || k<=0) return false;
        int sumForNums = 0;
        for (int i : nums) {
            sumForNums += i;
        }       

        if(sumForNums % k != 0) return false;
        return backtracking(nums, new boolean[nums.length], 0, 0, sumForNums/k, k);

    }

    private boolean backtracking(int[] nums, boolean[] used, int iterationStart, int bucketSum, int bucketMax, int k){
        if(k==1) return true;

        if(bucketSum == bucketMax){
            if(backtracking(nums, used, 0, 0, bucketMax, k-1)){
                return true;
            }
        }

        for(int i=iterationStart;i<nums.length;i++){
            if(!used[i] && bucketSum + nums[i] <= bucketMax){
                used[i] = true;
                if(backtracking(nums, used, i+1, bucketSum+nums[i], bucketMax, k)){
                    return true;
                }

                used[i] = false;
            }
        }

        return false;
    }
}