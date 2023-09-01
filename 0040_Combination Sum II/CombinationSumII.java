class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void backtracking(int[] candidates, int target, int index, List<Integer> list, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i=index;i<candidates.length;i++) {
            if(i > index && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;
            list.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i+1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}