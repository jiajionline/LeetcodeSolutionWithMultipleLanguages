public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while(l <= r)
        {
            int mid = (r-l)/2 + l;
            if(guess(mid) == 1)
                l = mid + 1;
            else if(guess(mid) == -1)
                r = mid - 1;
            else return mid;
        }
        
        return l;
    }
}