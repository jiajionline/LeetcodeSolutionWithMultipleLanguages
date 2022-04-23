class Solution {
public int minFlipsMonoIncr(String S) {

    int one = 0;
    int flip =0;
    for(int i=0;i<S.length();i++)
    {
        if(S.charAt(i)=='1')
            one++;
        else
            flip++;
        flip = Math.min(one,flip);
    }
    return flip;
}
}