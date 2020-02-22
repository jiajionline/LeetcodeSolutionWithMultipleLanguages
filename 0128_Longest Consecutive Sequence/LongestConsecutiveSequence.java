class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();

        for (Integer val : nums) {
            set.add(val);
        }

        for (Integer val : nums) {
            
            if(set.contains(val-1)) continue;

            int count = 0;
            while(set.contains(val++)){
                count++;
            }
            
            ans = Math.max(ans,count);
        }

        return ans;
    }
}