public class Solution {
    public int MaximumSwap(int num) {
        if(num < 10) return num;
        var buckets = new int[10];
        var chars = num.ToString().ToCharArray();
        for(int i=0;i<chars.Length;i++)
            buckets[chars[i] -'0'] = i;
        
        for(int i=0;i<chars.Length;i++) {
            for(int k=9;k> (chars[i] - '0'); k-- ) 
            {
                if(buckets[k] > i) 
                {
                    var tmp = chars[i];
                    chars[i] = chars[buckets[k]];
                    chars[buckets[k]] = tmp;
                    return int.Parse(new String(chars));
                }
            }
        }
        
        return num;
    }
}