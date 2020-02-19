class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        DFS(nums, used, curr, ans);
        return ans;
    }
    
    private void DFS(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> ans){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            
            // Same number can be only used once at each depth.
            // when a number has the same value with its previous, we can use this number only if his previous is used
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            curr.add(nums[i]);
            used[i] = true;
            DFS(nums , used, curr, ans);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
}