class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        DFS(nums, 0, used, curr, ans);
        return ans;
    }
    
    private void DFS(int[] nums, int s, boolean[] used, List<Integer> curr, List<List<Integer>> ans){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            curr.add(nums[i]);
            used[i] = true;
            DFS(nums, i+1, used, curr, ans);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
}