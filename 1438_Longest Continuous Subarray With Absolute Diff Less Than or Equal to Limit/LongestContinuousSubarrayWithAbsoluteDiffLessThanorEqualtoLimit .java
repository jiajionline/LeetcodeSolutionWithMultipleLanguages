class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int l = 0;
        // if two numbers are equal, compare the index , otherwise compare the value of the number
        TreeSet<Integer> set = new TreeSet<Integer>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
        int ans = 0;
        for (int r = 0; r < nums.length; r++) {
            set.add(r);
            while (nums[set.last()] - nums[set.first()] > limit) {
                set.remove(l++);
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}