class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.add(new ArrayList<Integer>());
        ans.get(0).add(1);
            
        for(int i=1;i<numRows;i++) {
            ans.add(new ArrayList<Integer>());
            List<Integer> prevList = ans.get(i-1);
            List<Integer> currList = ans.get(i);
            int len = prevList.size() + 1;
            for(int j=0;j<len;j++)
            {
                if(j == 0) {
                    currList.add(prevList.get(j));
                }else if(j == len - 1) {
                    currList.add(prevList.get(j-1));
                }else{
                    currList.add(prevList.get(j-1) + prevList.get(j));
                }
            }
        }
        
        return ans;
    }
}