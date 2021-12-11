public class Solution {
    public char NextGreatestLetter(char[] letters, char target) {
        var l = 0;
        var r = letters.Length - 1;
        
        while(l <= r)
        {
            var mid = (r - l)/2 + l;
            if((letters[mid] - 'a') > (target-'a'))
                r = mid-1;
            else
                l = mid+1;
        }
        
        return l == letters.Length ? letters[0] : letters[l];
    }
}