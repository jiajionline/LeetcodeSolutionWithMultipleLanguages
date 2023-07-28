class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int start = 0;
        while(start < nums.length) {
            int end = start;
            while(end+1 < nums.length && nums[end] + 1 == nums[end+1]) end++;
            if(start == end) {
                ans.add(""+nums[start]);
            }else{
                ans.add(nums[start] + "->" + nums[end]);
            }
            start = end+1;
        }

        return ans;
        
    }
}