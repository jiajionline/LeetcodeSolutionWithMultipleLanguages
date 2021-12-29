class Solution {
    private int[] _nums;
    private Random _rand;
    
    public Solution(int[] nums) {
        this._nums = nums;
        this._rand = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int ans = 0;
        for (int i = 0; i < _nums.length; ++i) {
            if (_nums[i] == target) {
                count++;
                if (_rand.nextInt(count) == 0) {
                    ans = i;
                }
            }
        }
        return ans;
    }
}