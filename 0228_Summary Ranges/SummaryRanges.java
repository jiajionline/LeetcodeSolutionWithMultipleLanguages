class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        while(index < nums.length) {
            int v = nums[index];
            while(index + 1 < nums.length && nums[index] + 1 == nums[index+1]) index++;
            if(v == nums[index]) {
                ans.add(String.valueOf(v));
            }else{
                ans.add(v + "->" + nums[index]);
            }
            index++;
        }

        return ans;
    }
}