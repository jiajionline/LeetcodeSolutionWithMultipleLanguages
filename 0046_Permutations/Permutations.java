class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        DFS(nums, 0, visited, curr, ans);
        return ans;
    }
    
    private void DFS(int[] nums, int s, boolean[] visited, List<Integer> curr, List<List<Integer>> ans){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            curr.add(nums[i]);
            visited[i] = true;
            DFS(nums, i+1, visited, curr, ans);
            curr.remove(curr.size()-1);
            visited[i] = false;
        }
    }
}