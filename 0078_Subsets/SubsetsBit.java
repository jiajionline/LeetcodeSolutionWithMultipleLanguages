public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < (1 << nums.length); ++i) {
            List<Integer> subSet = new ArrayList<>();

            for (int b = 0; b < nums.length; ++b) {
                if (((i >> b) & 1) == 1) {
                    subSet.add(nums[b]);
                }
            }

            result.add(subSet);
        }

        return result;
    }
}