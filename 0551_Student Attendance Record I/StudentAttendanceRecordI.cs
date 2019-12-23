public class Solution {
    public bool CheckRecord(string s) {
        if(s == null || s.Length == 0) return false;
        var absentCount = 0;
        var consecutiveLateCount = 0;
        for(int i=0;i<s.Length;i++){
            absentCount += (s[i] == 'A' ? 1 : 0);
            if(absentCount > 1) return false;
            if(s[i] == 'L'){
                consecutiveLateCount++;
                if(consecutiveLateCount > 2){
                    return false;
                }
            }else{
                consecutiveLateCount = 0;
            }
        }
        
        return true;
    }
}