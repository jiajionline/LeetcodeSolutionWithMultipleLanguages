public class Solution {
    public int NumJewelsInStones(string J, string S) {
        int ans = 0;
        if(String.IsNullOrEmpty(J) || String.IsNullOrEmpty(S)) return ans;
        foreach(var jewel in J){
            foreach(var stone in S){
                if(jewel.Equals(stone)){
                    ans++;
                }
            }
        }
        
        return ans;
    }
}