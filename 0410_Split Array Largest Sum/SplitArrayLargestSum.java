class Solution {
    private int[] _presum;
    private int[][] _mem;

    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        _presum = new int[n];
        _presum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            _presum[i] = nums[i] + _presum[i - 1];
        }

        _mem = new int[n][m + 1];
        for (int i = 0; i < _mem.length; i++) {
            for (int j = 0; j < _mem[i].length; j++) {
                _mem[i][j] = Integer.MAX_VALUE;
            }
        }

        return split(nums, n - 1, m);
    }

    private int split(int[] nums, int k, int m) {
        if (m == 1)
            return _presum[k];
        if (m > k + 1)
            return Integer.MAX_VALUE;
        if (_mem[k][m] != Integer.MAX_VALUE)
            return _mem[k][m];

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            ans = Math.min(ans, Math.max(split(nums, i, m - 1), _presum[k] - _presum[i]));
        }

        _mem[k][m] = ans;

        return ans;
    }
}
