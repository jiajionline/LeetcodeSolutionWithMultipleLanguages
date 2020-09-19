public class Solution {
    public void ReverseString(char[] s) {
        if(s == null || s.Length <=1 ) return;
        int start = 0;
        int end = s.Length -1;
        while(start < end){
            var tmp = s[start];
            s[start++] = s[end];
            s[end--] = tmp;
        }
    }
}