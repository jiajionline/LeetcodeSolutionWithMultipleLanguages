class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();

        DFS(1, n, k, cur, ans);

        return ans;
    }

    private void DFS(int s, int n, int k, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() == k) {
            ans.add(new ArrayList(cur));
            return;
        }

        for (int i = s; i <= n; i++) {
            cur.add(i);
            DFS(i + 1, n, k, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}