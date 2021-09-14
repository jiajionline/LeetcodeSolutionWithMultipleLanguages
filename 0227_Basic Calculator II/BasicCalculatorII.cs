public class Solution
    {
        public int Calculate(string s)
        {
            if (string.IsNullOrWhiteSpace(s)) return 0;
            
            char sign = '+';
            int num = 0;
            var stack = new Stack<int>();

            for (int i = 0; i < s.Length; i++)
            {
                var c = s[i];
                
                if (char.IsDigit(c))
                {
                    num = num * 10 + (c - '0');
                }

                if(!char.IsDigit(c) && ' ' != c || i == s.Length - 1)
                {
                    if(sign == '+') stack.Push(num);

                    if (sign == '-') stack.Push(-num);

                    if (sign == '*') stack.Push(stack.Pop() * num);

                    if (sign == '/') stack.Push(stack.Pop() / num);

                    sign = c;
                    num = 0;
                }
            }

            return stack.Sum();
        }
    }