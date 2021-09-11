public class Solution
    {
        public int Calculate(string s)
        {
            if (string.IsNullOrWhiteSpace(s)) return 0;

            int result = 0;
            int sign = 1;
            int num = 0;
            var stack = new Stack<int>();
            stack.Push(sign);

            foreach (var c in s)
            {
                if (char.IsDigit(c))
                {
                    num = num * 10 + (c - '0');
                }
                else if (c == '+' || c == '-')
                {
                    result += sign * num;
                    sign = stack.Peek() * (c == '+' ? 1 : -1);
                    num = 0;
                }
                else if (c == '(')
                {
                    stack.Push(sign);
                }
                else if (c == ')')
                {
                    stack.Pop();
                }
            }

            result += sign * num;
            return result;
        }
    }