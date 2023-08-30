class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(k, n, 1, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void backtracking(int k, int sum, int currIndex, List<Integer> list, List<List<Integer>> ans) {
        if(sum == 0) {
            if(list.size() == k)
                ans.add(new ArrayList<Integer>(list));
            return;
        }

        if(sum < 0 || list.size() >= k) return;

        for(int i = currIndex;i<=9;i++) {
            list.add(i);
            backtracking(k, sum-i, i+1, list, ans);
            list.remove(list.size()-1);
        }
    }
}