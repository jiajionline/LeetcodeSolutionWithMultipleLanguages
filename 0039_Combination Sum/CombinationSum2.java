class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        DFS(candidates, 0, target, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    private void DFS(int[] candidates, int index, int target, List<Integer> list, List<List<Integer>> ans) {
        if(target <= 0) {
            if(target == 0)
                ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i=index;i<candidates.length;i++) {
            list.add(candidates[i]);
            DFS(candidates, i, target - candidates[i], list, ans);
            list.remove(list.size()-1);
        }       
    }
}