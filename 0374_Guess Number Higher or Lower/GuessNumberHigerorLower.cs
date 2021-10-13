/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution : GuessGame {
    public int GuessNumber(int n) {
        var low = 1;
        var high = n;
        
        while(low <= high)
        {
            var mid = (high - low)/2 + low;
            var r = guess(mid);
            if(r == 0) 
                return mid;
            else if(r == 1)
                low = mid+1;
            else
                high = mid - 1;
        }
        
        return -1;
    }
}