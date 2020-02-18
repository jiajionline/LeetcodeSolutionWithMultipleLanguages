class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        List<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(candidates);
        DFS(candidates, target, 0, cur, ans);
        return ans;
    }

    private void DFS(int[] candidates, int target, int s, List<Integer> cur, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<Integer>(cur));
            return;
        }

        for(int i=s;i<candidates.length;i++){
            if(candidates[i] > target) break;
            if (i > s && candidates[i] == candidates[i-1]) continue;
            cur.add(candidates[i]);
            DFS(candidates, target - candidates[i], i, cur, ans);
            cur.remove(cur.size()-1);
        }
    }
}