class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> ans = new ArrayList<>();
        int prev = lower-1;
        for(int i=0;i<=nums.length;i++) {
            int curr = i < nums.length ? nums[i] : upper + 1;
            if(prev + 1 <= curr - 1) {
                List<Integer> list = new ArrayList<>();
                list.add(prev + 1);
                list.add(curr - 1);
                ans.add(list);
            }
            prev = curr;

        }
        
        return ans;
    }
}