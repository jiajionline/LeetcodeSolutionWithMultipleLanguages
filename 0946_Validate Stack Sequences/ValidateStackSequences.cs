public class Solution {
    public bool ValidateStackSequences(int[] pushed, int[] popped) {
        if(pushed.Length != popped.Length) return false;
        int n = pushed.Length;
        var stack = new Stack<int>();
        int pIndex = 0;
        foreach(var item in pushed) 
        {
            stack.Push(item);
            while(pIndex < n && stack.Count > 0 && stack.Peek() == popped[pIndex])
            {
                pIndex++;
                stack.Pop();
            }
        }
        
        return pIndex == n;
    }
}