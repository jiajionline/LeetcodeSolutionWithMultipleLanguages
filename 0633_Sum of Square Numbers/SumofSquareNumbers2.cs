public class Solution {
    public bool JudgeSquareSum(int c) {
        var s = 0;
        var e = Math.Ceiling(Math.Sqrt(c));
        
        while(s <= e)
        {
            var k = s*s + e*e;
            
            if(k == c){
                return true;
            }else if(k < c){
                s++;    
            }else{
                e--;
            }
        }
        
        return false;
    }
}