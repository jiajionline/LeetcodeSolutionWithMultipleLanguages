class Solution {
  
    public List<String> maxNumOfSubstrings(String s) {
        //the position which the letter starts
        int[] sPosition = new int[26]; 
        //the position which the letter ends
        int[] ePosition = new int[26];
        Arrays.fill(sPosition, s.length());
        var ans = new ArrayList<String>();
        //i is the postion of current letter
        for (int i = 0; i < s.length(); ++i) {
            //the letter
            var ch = s.charAt(i) - 'a';
            //update start position of ch
            sPosition[ch] = Math.min(sPosition[ch], i);
            //update end position of ch
            ePosition[ch] = i;
        }
        
        int end = -1;
        for (int i = 0; i < s.length(); ++i)
            if (i == sPosition[s.charAt(i) - 'a']) {
                int new_end = checkSubstr(s, i, sPosition, ePosition);
                //valid
                if (new_end != -1) {
                    // find a new non-overlapped substring
                    if (i > end)
                        ans.add("");                     
                    end = new_end;
                    //update last element of List ans
                    ans.set(ans.size() - 1, s.substring(i, end + 1));
                }
            }
        return ans;
    }
    
    //get the max end position for current position i. 
    private int checkSubstr(String s, int i, int[] sPosition, int[] ePosition) {
        //get the end position of the letter
        int end = ePosition[s.charAt(i) - 'a'];
        //scan from i to end
        for (int j = i; j <= end; ++j) {
            //there is a letter which start position is less than i, means the substring between i to end, doesn't include all letters.
            if (sPosition[s.charAt(j) - 'a'] < i)
                return -1;
            //find the max end position in the letters which is between i to end
            end = Math.max(end, ePosition[s.charAt(j) - 'a']);
        }
        return end;
    }  
}