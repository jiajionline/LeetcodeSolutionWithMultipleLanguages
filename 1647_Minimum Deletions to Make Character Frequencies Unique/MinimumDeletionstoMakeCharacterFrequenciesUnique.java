class Solution {
    public int minDeletions(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray())
            count[c - 'a']++;
        
        var ans = 0;
        HashSet<Integer> set = new HashSet();
        
        for(int i=0;i<count.length;i++)
        {
            while(count[i] > 0 && !set.add(count[i]))
            {
                count[i]--;
                ans++;
            }
        }
        
        return ans;
    }
}