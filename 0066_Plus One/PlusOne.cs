public class Solution {
    public int[] PlusOne(int[] digits) {
        if(digits == null || digits.Length == 0) return new int[1]{1};
        
        var stack = new Stack<int>();
        var carry = true;
        
        var index = digits.Length - 1;
        
        while(index>=0 || carry){
            
            var num = carry ? 1 : 0;
            if(index >= 0){
                num += digits[index--];
            }
            
            carry = num >= 10;
            num %= 10;
            
            stack.Push(num);
            
        }
        
        var ans = new int[stack.Count];
        for(int i=0;i<ans.Length;i++){
            ans[i] = stack.Pop();
        }
        
        return ans;
    }
}