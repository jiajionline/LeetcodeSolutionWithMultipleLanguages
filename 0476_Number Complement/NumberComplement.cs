class Solution {
    public int FindComplement (int num) {
        var i = 1;
        while (i < num) {
            i <<= 1;
            i += 1;
        }

        return i - num;
    }
}