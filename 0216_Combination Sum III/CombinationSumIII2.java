class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<(1<<9);i++) {
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for(int j=0;j<=8;j++) {
                if((1 & (i>>j)) > 0){
                    sum+=(j+1);
                    list.add(j+1);
                }
            }

            if(list.size() == k && sum == n) ans.add(list);
        }
        return ans;
    }
}