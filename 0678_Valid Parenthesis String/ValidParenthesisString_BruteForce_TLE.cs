public class Solution {
    private bool isValid = false;
    public bool CheckValidString(string s) {
        var chs = s.ToCharArray();
        Solve(chs, 0);
        return isValid;
    }
    
    private void Solve(char[] chs, int index) {
        if(index == chs.Length) {
            isValid = Valid(chs);
            return;
        }
        
        if(chs[index] == '*') {
            foreach(var c in "() ") {
                chs[index] = c;
                Solve(chs, index+1);
                if(isValid) return;
            }
            chs[index] = '*';
        }else {
            Solve(chs, index+1);
        }
    }
    
    private bool Valid(char[] chs)
    {
        int bal = 0;
        for(int i=0;i<chs.Length;i++) {
            if(chs[i] == '(') bal++;
            if(chs[i] == ')') bal--;
            if(bal < 0) break;
        }
        
        return bal == 0;
    }
}