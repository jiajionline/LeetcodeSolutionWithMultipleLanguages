public class Solution {
    public string LongestCommonPrefix(string[] strs) {
        if(strs == null || strs.Length == 0) return "";
        if(strs.Length == 1) return strs[0];

        var sb = new StringBuilder();
        for(int i=0;i<int.MaxValue;i++){
            var c = Common(strs, i);
            if(c != '#'){
                sb.Append(c);
            }else{
                break;
            }
        }

        return sb.ToString();
    }

    private char Common(string[] strs, int index){
        if(index >= strs[0].Length ) return '#';
        var baseChar = strs[0][index];

        for(int i=1;i<strs.Length;i++){
            var s = strs[i];
            if(index >= s.Length) return '#';
            if(s[index] != baseChar) return '#';
        }

        return baseChar;
    }
}