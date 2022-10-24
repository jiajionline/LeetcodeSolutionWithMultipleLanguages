class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int row=0;row<numRows;row++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            if(row > 0) {
                List<Integer> lastList = ans.get(row-1);
                for(int j=1;j<lastList.size();j++) {
                    int v = lastList.get(j-1) + lastList.get(j);
                    list.add(v);
                }
                list.add(1);
            }
            ans.add(list);
        }
        
        return ans;
    }
}