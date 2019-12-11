using System.Text.RegularExpressions;

public class Solution {
    public string ReverseWords(string s) {
        if(string.IsNullOrEmpty(s)) return s;
        s = s.Trim();
        s = Regex.Replace(s, @"\s+", " ");
        var charArr = s.ToCharArray();
        Reverse(charArr, 0, s.Length - 1);
        var start = 0;
        var end = 0;
        while(end < charArr.Length) {
            if(charArr[end] == ' ') {
                Reverse(charArr, start, end - 1);
                end++;
                start = end;
            } else {
                end++;
            }
        }

        Reverse(charArr, start, end - 1);

        return new string(charArr);
    }

    private void Reverse(char[] charArr, int start, int end) {
        while(start < end) {
            var tmp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = tmp;
            start++;
            end--;
        }
    }
}