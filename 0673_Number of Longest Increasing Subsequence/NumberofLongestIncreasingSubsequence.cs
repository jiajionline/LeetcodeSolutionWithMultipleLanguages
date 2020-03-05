public class Solution {
    public int FindNumberOfLIS(int[] nums) {
        if(nums == null || nums.Length == 0) return 0;
        if(nums.Length == 1) return 1;
        var c = Enumerable.Repeat(1, nums.Length).ToArray();
        var l = Enumerable.Repeat(1, nums.Length).ToArray();

        for(int i = 1; i < nums.Length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(l[j] + 1 > l[i]) {
                        l[i] = l[j] + 1;
                        c[i] = c[j];
                    } else if(l[j] + 1 == l[i]) {
                        c[i] += c[j];
                    }
                }
            }
        }

        int maxLen = l.Max();

        int ans = 0;
        for(int i = 0; i < l.Length; ++i)
            if(l[i] == maxLen)
                ans += c[i];

        return ans;
    }
}