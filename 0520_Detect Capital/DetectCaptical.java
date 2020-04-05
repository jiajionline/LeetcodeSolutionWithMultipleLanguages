
public class Solution {
    public boolean detectCapitalUse(String word)
    {
        if (word == null || word.length() == 0) return false;
        int countCapital = 0;
        int countNonCapital = 0;
        int other = 0;

        for(char c : word.toCharArray())
        {
            if(c >= 'A' && c <= 'Z')
            {
                countCapital++;
            }else if(c >= 'a' && c <= 'z')
            {
                countNonCapital++;
            }
            else
            {
                other++;
            }
        }

        if(other > 0)
        {
            return false;
        }
       
        if(countNonCapital == word.length() || countCapital == word.length())
        {
            return true;
        }

        if(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z' && countNonCapital == word.length() - 1)
        {
            return true;
        }

        return false;
    }
}
