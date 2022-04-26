class Solution {
    public char findTheDifference(String s, String t) {
        char v = 0;
        for(char c1 : s.toCharArray()) v ^= c1;
        for(char c2 : t.toCharArray()) v ^= c2;
        return v;
    }
}