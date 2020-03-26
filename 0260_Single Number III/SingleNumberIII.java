class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];

        int exclusiveValue = 0;
        for (int i = 0; i < nums.length; i++) {
            exclusiveValue ^= nums[i];
        }

        int index = firstBitIs1(exclusiveValue);

        for (int i = 0; i < nums.length; i++) {
            if (isOne(nums[i], index)) {
                ans[0] ^= nums[i];
            } else {
                ans[1] ^= nums[i];
            }
        }

        return ans;
    }

    private boolean isOne(int current, int index) {
        return ((current >> index) & 1) == 1;
    }

    private int firstBitIs1(int v) {

        int index = 0;
        while (((v & 1) == 0) && index < 32) {
            v >>= 1;
            index++;
        }

        return index;
    }
}
