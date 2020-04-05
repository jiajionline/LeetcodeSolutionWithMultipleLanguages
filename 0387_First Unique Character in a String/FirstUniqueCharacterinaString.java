public class Solution {
    public int firstUniqChar(String s)
    {
        if (s == null || s.length() == 0) return -1;
        if (s.length() == 1) return 0;

        int[] letterToCount = new int[26];
        for(char c : s.toCharArray())
        {
            letterToCount[c - 'a']++;
        }

        for(int i =0;i<s.length();i++)
        {
            if(letterToCount[s.charAt(i) - 'a'] == 1)
            {
                return i;
            }
        }

        return -1;
    }
}
