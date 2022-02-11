public class Solution {
    public char NextGreatestLetter(char[] letters, char target) {
        var l = 0;
        var r = letters.Length;
        
        while(l < r)
        {
            var mid = (r - l)/2 + l;
            if(letters[mid] > target)
                r = mid;
            else
                l = mid+1;
        }
        
        return l == letters.Length ? letters[0] : letters[l];
    }
}