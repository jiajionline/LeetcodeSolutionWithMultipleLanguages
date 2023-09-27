class Solution {
    public boolean detectCapitalUse(String word) {
        int cntOfUpper = 0,  n = word.length();
        for(char c : word.toCharArray()) {
            if(Character.isUpperCase(c)){
                cntOfUpper++;
            }
        }

        return cntOfUpper == 0 || cntOfUpper == n ||  (cntOfUpper == 1 && Character.isUpperCase(word.charAt(0)));
    }
}