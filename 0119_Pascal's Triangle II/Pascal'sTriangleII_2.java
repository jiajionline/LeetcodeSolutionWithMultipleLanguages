class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(1);
        
        for(int i=1;i<=rowIndex;i++)
        {
            int[] curr = new int[ans.size() + 1];
            for(int j=0;j<=ans.size();j++)
            {
                if(j == 0)
                    curr[j] = ans.get(j);
                else if(j == ans.size())
                    curr[j] = ans.get(j-1);
                else
                    curr[j] = ans.get(j) + ans.get(j-1);
            }
            
            ans = Arrays.stream(curr).boxed().collect(Collectors.toList());
                
        }
        
        return ans;
    }
}