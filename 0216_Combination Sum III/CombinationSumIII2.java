class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        for(int i=0;i<(1<<9);i++){
            List<Integer> curr = new ArrayList<Integer>();
            int sum = 0;
            for(int j=1;j<=9;j++){
                if((i & (1 << (j-1))) > 0){
                    sum += j;
                    curr.add(j);
                }
            }

            if (sum == n && curr.size() == k) ans.add(curr);
        }

        return ans;
    }
}