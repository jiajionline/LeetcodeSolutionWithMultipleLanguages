class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();

        for(int n=0;n<=nums.length;n++){
            DFS(nums, 0,n,cur,ans);
        }

        return ans;
    }

    private void DFS(int[] nums, int s, int n, List<Integer> cur, List<List<Integer>> ans){
        if(cur.size() == n){
            ans.add(new ArrayList(cur));
            return;
        }

        for(int i=s;i<nums.length;i++){
            cur.add(nums[i]);
            DFS(nums, i+1,n,cur,ans);
            cur.remove(cur.size()-1);
        }
    }
}