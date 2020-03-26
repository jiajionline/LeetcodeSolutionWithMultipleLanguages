class Solution {
    public int SingleNumber (int[] nums) {
        int ret = 0;

        foreach (var i in nums) {
            ret ^= i;
        }

        return ret;
    }
}