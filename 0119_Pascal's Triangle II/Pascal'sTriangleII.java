class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] ans = new int[rowIndex+1];
        ans[0] = 1;
        for(int i=1;i<=rowIndex;i++)
        {
            for(int j=i;j>=1;j--)
                ans[j] += ans[j-1];
        }
        
        return Arrays.stream(ans).boxed().collect(Collectors.toList());
    }
}