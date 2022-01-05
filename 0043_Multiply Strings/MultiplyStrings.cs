public class Solution {
    public string Multiply(string num1, string num2) {
        var m = num1.Length;
        var n = num2.Length;
        
        var pos = new int[m + n];
        
        for(var i=m-1;i>=0;i--)
        {
            for(var j=n-1;j>=0;j--)
            {
                var mul = (num1[i] - '0') * (num2[j] - '0');
                var sum = mul + pos[i+j+1];
                pos[i+j] += sum / 10;
                pos[i+j+1] = sum % 10;
            }
        }
        
        var sb = new StringBuilder();
        foreach(var v in pos)
        {
            if(v == 0 && sb.Length == 0) continue;
            else sb.Append(v);
        }
            
        return sb.Length == 0 ? "0" : sb.ToString();
    }
}