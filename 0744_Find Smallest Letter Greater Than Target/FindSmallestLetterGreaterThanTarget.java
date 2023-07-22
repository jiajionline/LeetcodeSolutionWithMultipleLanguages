class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length;
        while(l < r) {
            int mid = (r-l)/2 + l;
            char char_mid = letters[mid];
            if(char_mid > target) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return l == letters.length ? letters[0] : letters[l];
    }
}