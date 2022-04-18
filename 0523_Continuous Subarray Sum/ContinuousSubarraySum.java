class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2 || k == 0) return false;
        
        Map<Integer, Integer> map = new HashMap<>();
        // key is the presum, value is the index for the presum
        // 0 is the presum, -1 means the index, this is the corner case to handle the whole current array. (there is no sum2)
        map.put(0, -1);
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            // only keey the mod
            curSum = curSum % k;
            
            // (sum1 - sum2) % k == 0 ===> sum1 % k == sum2 % k
            if (map.containsKey(curSum)) {
                if (i - map.get(curSum) > 1) {
                    return true;
                }
            }
            else {
                map.put(curSum, i);
            }
        }
        return false;
    }
}