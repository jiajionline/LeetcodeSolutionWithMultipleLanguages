public class Solution {
    public int FourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A == null || B == null || C == null || D == null) return 0;
        var dict = new Dictionary<int,int>();
        int ans = 0;
        
        foreach(var a in A){
            foreach(var b in B){
                if(!dict.ContainsKey(a + b)){
                    dict.Add(a+b,0);
                }
                
                dict[a+b] +=1;
            }
        }
        
        foreach(var c in C){
            foreach(var d in D){
                if(dict.ContainsKey(-(c+d))){
                    ans += dict[-(c+d)];
                }
            }
        }
        
        return ans;
    }
}