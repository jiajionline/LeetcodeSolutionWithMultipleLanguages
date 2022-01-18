class Solution {
    public List<Integer> partitionLabels(String s) {
    
        int[] occurances = new int[128];
        for(int i=0;i<s.length();i++)
            occurances[s.charAt(i)] = i;
        
        int start = 0;
        int end = 0;
        List<Integer> ans = new ArrayList<Integer>();
        
        for(int i=0;i<s.length();i++) {
            if(occurances[s.charAt(i)] > end)
                end = occurances[s.charAt(i)];
            
            if(i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
       
        return ans;
    }
}