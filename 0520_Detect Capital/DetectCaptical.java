class Solution {
    public boolean detectCapitalUse(String word) {
        boolean firstCapital = Character.isUpperCase(word.charAt(0));
        int countCapital = 0;
        
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            if(Character.isUpperCase(c)) countCapital++;
        }
        
        return word.length() == countCapital || (firstCapital && countCapital == 1) || countCapital == 0;
    }
}