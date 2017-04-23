using System.Collections.Generic;

namespace LeetcodePracticeCsharpVersion
{
    class ValidParentheses
    {
        public bool IsValid(string s)
        {
            if (s == null || s.Length % 2 != 0) return false;
            Stack<char> stack = new Stack<char>();

            foreach(var c in s)
            {
                if (c == '(')
                    stack.Push(')');
                else if (c == '[')
                    stack.Push(']');
                else if (c == '{')
                    stack.Push('}');
                else
                {
                    if (stack.Count == 0 || stack.Pop() != c)
                    {
                        return false;
                    }
                }                
            }

            return stack.Count == 0;
        }
    }
}
