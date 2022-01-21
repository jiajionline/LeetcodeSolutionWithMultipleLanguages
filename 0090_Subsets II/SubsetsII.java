class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        subsets(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    private void subsets(int[] nums, int index, List<Integer> list, List<List<Integer>> ans) {
        ans.add(new ArrayList<Integer>(list));
        
        for(int i=index;i<nums.length;i++) {
            if(i > index && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            subsets(nums, i+1, list, ans);
            list.remove(list.size()-1);
        }
    }
}