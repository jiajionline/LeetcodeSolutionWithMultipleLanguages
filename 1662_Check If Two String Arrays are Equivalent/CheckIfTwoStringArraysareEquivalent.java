class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int w1Index = 0, w2Index = 0 , p1 = 0 , p2 = 0;
        
        while(w1Index < word1.length && w2Index < word2.length) {
            if(word1[w1Index].charAt(p1++) != word2[w2Index].charAt(p2++)) return false;
            if(p1 == word1[w1Index].length()) { w1Index++; p1 = 0;}
            if(p2 == word2[w2Index].length()) { w2Index++; p2 = 0;}
        }
        
        return w1Index == word1.length && w2Index == word2.length && p1 == 0 && p2 == 0;
    }
}