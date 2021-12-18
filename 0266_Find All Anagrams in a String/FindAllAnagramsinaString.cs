public class Solution {
    public bool CanPermutePalindrome(string s) {
        var count = new int[26];
        foreach(var c in s)
        {
            var i = c-'a';
            if(count[i] == 0) count[i]++;
            else count[i]--;
        }
        
        return AtMostHas1(count);
    }
    
    private bool AtMostHas1(int[] count)
    {
        var atMost1 = 0;
        for(int i=0;i<count.Length;i++)
        {
            if(count[i] > 1)
                atMost1 = 2;
            
            if(count[i] == 1) atMost1++;
        }
        
        return atMost1 <= 1;
    }
}